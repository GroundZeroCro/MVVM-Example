package com.groundzero.asynclabs.di.coremodules

import com.groundzero.asynclabs.base.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityModule {
    @ContributesAndroidInjector(modules = [FragmentsModule::class])
    abstract fun contributeActivity(): MainActivity
}