package com.mostafa.jakewhartontask.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.mostafa.jakewhartontask.data.model.User
import com.mostafa.jakewhartontask.data.model.UserOwner

/**
 * Created by µðšţãƒâ ™ on 10/14/2019.
 *  ->
 */
@Dao
interface UserDao {
    @Query("SELECT users.*, owners.* FROM users INNER JOIN owners WHERE userId = fkUserId")
    fun getAllUsers(): MutableList<UserOwner>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllUser(users: MutableList<User>)
}