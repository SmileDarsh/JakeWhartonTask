package com.mostafa.jakewhartontask.di.module

import com.mostafa.jakewhartontask.views.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by µðšţãƒâ ™ on 10/14/2019.
 *  ->
 */
@Module
abstract class ActivityModule {

    @ContributesAndroidInjector
    abstract fun contributeMainActivity(): MainActivity
}