package com.mostafa.jakewhartontask.di.component

import android.app.Application
import com.mostafa.jakewhartontask.base.AppTask
import com.mostafa.jakewhartontask.di.module.ActivityModule
import com.mostafa.jakewhartontask.di.module.DataMangerModule
import com.mostafa.jakewhartontask.di.module.RetrofitModule
import com.mostafa.jakewhartontask.di.module.RoomModule
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

/**
 * Created by µðšţãƒâ ™ on 10/13/2019.
 * ->
 */
@Singleton
@Component(modules = [RetrofitModule::class, DataMangerModule::class, RoomModule::class, ActivityModule::class])
interface AppComponent {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }

    fun inject(appController: AppTask)
}