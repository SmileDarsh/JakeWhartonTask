package com.mostafa.jakewhartontask.data.model

import androidx.room.Embedded

/**
 * Created by µðšţãƒâ ™ on 10/15/2019.
 * ->
 */
class UserOwner{
    @Embedded
    var user : User? = null

    @Embedded
    var owner : Owner? = null
}