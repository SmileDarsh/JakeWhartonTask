package com.mostafa.jakewhartontask.data

import com.mostafa.jakewhartontask.data.local.LocalDataSource
import com.mostafa.jakewhartontask.data.remote.RemoteDataSource

/**
 * Created by µðšţãƒâ ™ on 10/13/2019.
 * ->
 */
interface DataManger : RemoteDataSource, LocalDataSource {
}