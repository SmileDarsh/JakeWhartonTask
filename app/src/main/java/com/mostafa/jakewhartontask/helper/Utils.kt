package com.mostafa.jakewhartontask.helper

import android.content.Context
import android.content.Context.CONNECTIVITY_SERVICE
import android.net.ConnectivityManager
import com.mostafa.jakewhartontask.data.model.UserOwner


/**
 * Created by µðšţãƒâ ™ on 10/15/2019.
 * ->
 */
object Utils {

    fun returnListByPage(users: MutableList<UserOwner>, page: Int): MutableList<UserOwner> {
        val userByPage = mutableListOf<UserOwner>()
        var itemPosition = page * 15
        val size = users.size
        for (it in 0..14) {
            if (itemPosition < size) {
                userByPage.add(users[itemPosition])
                itemPosition++
            }
        }
        return userByPage
    }

    fun isNetworkConnected(context: Context): Boolean {
        val cm = context.getSystemService(CONNECTIVITY_SERVICE) as ConnectivityManager?
        return cm!!.activeNetworkInfo != null && cm.activeNetworkInfo.isConnected
    }
}