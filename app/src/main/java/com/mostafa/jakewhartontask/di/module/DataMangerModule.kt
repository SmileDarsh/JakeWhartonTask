package com.mostafa.jakewhartontask.di.module

import com.mostafa.jakewhartontask.data.AppDataManger
import com.mostafa.jakewhartontask.data.DataManger
import com.mostafa.jakewhartontask.data.local.AppDatabase
import com.mostafa.jakewhartontask.data.local.LocalData
import com.mostafa.jakewhartontask.data.local.LocalDataSource
import com.mostafa.jakewhartontask.data.remote.RemoteData
import com.mostafa.jakewhartontask.data.remote.RemoteDataSource
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

/**
 * Created by µðšţãƒâ ™ on 10/13/2019.
 * ->
 */
@Module
class DataMangerModule{

    @Provides
    @Singleton
    fun provideRemoteDataSource(retrofit: Retrofit) : RemoteDataSource {
        return RemoteData(retrofit)
    }

    @Provides
    @Singleton
    fun provideLocalDataSource(room: AppDatabase) : LocalDataSource {
        return LocalData(room)
    }


    @Provides
    @Singleton
    fun provideDataManger(remoteDataSource: RemoteDataSource, localDataSource: LocalDataSource) : DataManger{
        return AppDataManger(remoteDataSource, localDataSource)
    }
}