package com.mostafa.jakewhartontask.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.mostafa.jakewhartontask.data.local.dao.OwnerDao
import com.mostafa.jakewhartontask.data.local.dao.UserDao
import com.mostafa.jakewhartontask.data.model.Owner
import com.mostafa.jakewhartontask.data.model.User

/**
 * Created by µðšţãƒâ ™ on 10/13/2019.
 * ->
 */
@Database(entities = [User::class , Owner::class], version = 1 , exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun userDao(): UserDao

    abstract fun ownerDao(): OwnerDao
}