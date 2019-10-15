package com.mostafa.jakewhartontask.di.module

import android.app.Application
import androidx.room.Room
import com.mostafa.jakewhartontask.data.local.AppDatabase
import com.mostafa.jakewhartontask.data.local.dao.UserDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by µðšţãƒâ ™ on 10/13/2019.
 * ->
 */
@Module
class RoomModule {

    @Provides
    @Singleton
    fun provideDatabase(app: Application): AppDatabase {
        return Room.databaseBuilder(app, AppDatabase::class.java, "user.db")
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    @Singleton
    fun provideUserDao(appDatabase: AppDatabase): UserDao {
        return appDatabase.userDao()
    }
}