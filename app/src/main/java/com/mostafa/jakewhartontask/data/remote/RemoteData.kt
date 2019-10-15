package com.mostafa.jakewhartontask.data.remote

import com.mostafa.jakewhartontask.base.ApiService
import com.mostafa.jakewhartontask.data.model.User
import io.reactivex.Flowable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import retrofit2.Response
import retrofit2.Retrofit
import javax.inject.Inject

/**
 * Created by µðšţãƒâ ™ on 10/13/2019.
 * ->
 */
class RemoteData @Inject constructor(private val mRetrofit: Retrofit) : RemoteDataSource {

    override fun getUsers(page : Int): Flowable<Response<MutableList<User>>> {
        val userService = mRetrofit.create(ApiService::class.java)
        return userService.getUsers(page,15)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }
}