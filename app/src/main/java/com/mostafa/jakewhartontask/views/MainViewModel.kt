package com.mostafa.jakewhartontask.views

import android.content.Context
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import com.mostafa.jakewhartontask.BR
import com.mostafa.jakewhartontask.data.DataManger
import com.mostafa.jakewhartontask.data.model.User
import com.mostafa.jakewhartontask.data.model.UserOwner
import com.mostafa.jakewhartontask.helper.Utils
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.processors.PublishProcessor
import io.reactivex.schedulers.Schedulers
import retrofit2.HttpException
import javax.inject.Inject

/**
 * Created by µðšţãƒâ ™ on 10/14/2019.
 *  ->
 */
class MainViewModel @Inject constructor(private val mDataManager: DataManger) : BaseObservable() {
    private var mRequestOnWay = false
    private var isConnected = true
    private var mVisible = false
    private var mUsers = mutableListOf<UserOwner>()
    private var mCompositeDisposable = CompositeDisposable()
    private var mPagination: PublishProcessor<Int>? = null
    private var mAdapter = UsersAdapter()
    private var mCurrentPage = 0

    init {
        mPagination = PublishProcessor.create()
    }

    fun addOnScrollListener(currentPage: Int) {
        if (!mRequestOnWay) {
            mCurrentPage = currentPage
            mPagination!!.onNext(mCurrentPage)
            if (!isConnected)
                mAdapter.setUser(Utils.returnListByPage(mUsers, mCurrentPage))
        }
    }

    fun fetchData(context: Context) {
        isConnected = Utils.isNetworkConnected(context)
        if (isConnected)
            remoteData()
        else {
            Toast.makeText(context, "Please check your internet connection or try again later", Toast.LENGTH_LONG).show()
            localData()
        }
    }

    private fun remoteData() {
        val disposable = mPagination!!.onBackpressureDrop()
            .doOnNext {
                mRequestOnWay = true
            }
            .concatMap {
                mDataManager.getUsers(it)
            }
            .observeOn(AndroidSchedulers.mainThread())
            .doOnNext { t ->
                if (t!!.isSuccessful) {
                    t.body()!!.forEach {
                        val userOwner = UserOwner()
                        userOwner.user = it
                        userOwner.owner = it.owner
                        userOwner.owner!!.userId = it.id
                        mUsers.add(userOwner)
                    }
                    mAdapter.setUser(mUsers)
                    mUsers.clear()
                    insertUser(t.body()!!)
                    removeProgress()
                }
                mRequestOnWay = false
            }
            .doOnError {
                if (it is HttpException) {
                    val response = it.response()
                    Log.e("TAG Error", response.message())
                }
            }
            .retry(3)
            .subscribe()

        mCompositeDisposable.add(disposable)

        mPagination!!.onNext(0)
    }

    private fun insertUser(users: MutableList<User>) {
        val disposableUser = mDataManager.insertAllUsers(users)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe()

        mCompositeDisposable.add(disposableUser)
    }

    private fun localData() {
        val disposable = mDataManager.getAllUsers()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe {
                removeProgress()
                mUsers.addAll(it)
                mAdapter.setUser(Utils.returnListByPage(mUsers, mCurrentPage))
            }
        mCompositeDisposable.add(disposable)
    }

    private fun removeProgress() {
        mVisible = true
        notifyPropertyChanged(BR.visible)
    }

    fun dispose() {
        mCompositeDisposable.dispose()
    }

    @Bindable
    fun getUserAdapter(): UsersAdapter {
        return mAdapter
    }

    @Bindable
    fun getVisible(): Int {
        return if (mVisible) View.GONE else View.VISIBLE
    }
}