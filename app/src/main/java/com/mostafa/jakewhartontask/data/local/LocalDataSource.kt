package com.mostafa.jakewhartontask.data.local

import com.mostafa.jakewhartontask.data.model.Owner
import com.mostafa.jakewhartontask.data.model.User
import com.mostafa.jakewhartontask.data.model.UserOwner
import io.reactivex.Observable

/**
 * Created by µðšţãƒâ ™ on 10/13/2019.
 * ->
 */
interface LocalDataSource {
    fun insertAllUsers(users: MutableList<User>) : Observable<*>

    fun getAllUsers() : Observable<MutableList<UserOwner>>

    fun insertOwner(owner: Owner) : Observable<*>
}