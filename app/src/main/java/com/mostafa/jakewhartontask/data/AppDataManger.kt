package com.mostafa.jakewhartontask.data

import com.mostafa.jakewhartontask.data.local.LocalDataSource
import com.mostafa.jakewhartontask.data.model.Owner
import com.mostafa.jakewhartontask.data.model.User
import com.mostafa.jakewhartontask.data.model.UserOwner
import com.mostafa.jakewhartontask.data.remote.RemoteDataSource
import io.reactivex.Flowable
import io.reactivex.Observable
import retrofit2.Response
import javax.inject.Inject

/**
 * Created by µðšţãƒâ ™ on 10/13/2019.
 * ->
 */
class AppDataManger @Inject constructor(
    private val mRemoteDataSource: RemoteDataSource,
    private val mLocalDataSource: LocalDataSource
) : DataManger {

    override fun getUsers(page: Int): Flowable<Response<MutableList<User>>> {
        return mRemoteDataSource.getUsers(page)
    }

    override fun insertAllUsers(users: MutableList<User>): Observable<*> {
        return mLocalDataSource.insertAllUsers(users)
    }

    override fun getAllUsers(): Observable<MutableList<UserOwner>> {
        return mLocalDataSource.getAllUsers()
    }

    override fun insertOwner(owner: Owner): Observable<*> {
        return mLocalDataSource.insertOwner(owner)
    }
}