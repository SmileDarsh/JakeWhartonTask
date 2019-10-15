package com.mostafa.jakewhartontask.data.remote

import com.mostafa.jakewhartontask.data.model.User
import io.reactivex.Flowable
import retrofit2.Response

/**
 * Created by µðšţãƒâ ™ on 10/13/2019.
 * ->
 */
interface RemoteDataSource {
    fun getUsers(page : Int): Flowable<Response<MutableList<User>>>
}