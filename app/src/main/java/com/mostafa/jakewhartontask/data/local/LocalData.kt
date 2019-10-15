package com.mostafa.jakewhartontask.data.local

import com.mostafa.jakewhartontask.data.model.Owner
import com.mostafa.jakewhartontask.data.model.User
import com.mostafa.jakewhartontask.data.model.UserOwner
import io.reactivex.Observable
import javax.inject.Inject

/**
 * Created by µðšţãƒâ ™ on 10/13/2019.
 * ->
 */
class LocalData @Inject constructor(private val mRoom: AppDatabase) : LocalDataSource {

    override fun insertAllUsers(users: MutableList<User>): Observable<*> {
        return Observable.fromCallable {
            users.forEach {
                val owner = it.owner
                owner.userId = it.id
                mRoom.ownerDao().insertOwner(owner)
            }
            return@fromCallable mRoom.userDao().insertAllUser(users)
        }
    }

    override fun getAllUsers(): Observable<MutableList<UserOwner>> {
        return Observable.fromCallable { return@fromCallable mRoom.userDao().getAllUsers() }
    }

    override fun insertOwner(owner: Owner): Observable<*> {
        return Observable.fromCallable { return@fromCallable mRoom.ownerDao().insertOwner(owner) }
    }
}