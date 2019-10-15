package com.mostafa.jakewhartontask.base

import com.mostafa.jakewhartontask.data.model.User
import io.reactivex.Flowable
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by µðšţãƒâ ™ on 10/13/2019.
 * ->
 */
interface ApiService {
    @GET("users/JakeWharton/repos")
    fun getUsers(@Query("page") page: Int, @Query("per_page") per_page: Int): Flowable<Response<MutableList<User>>>
}