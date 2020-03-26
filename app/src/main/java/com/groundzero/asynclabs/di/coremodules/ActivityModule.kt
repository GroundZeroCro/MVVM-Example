package com.groundzero.asynclabs.di.coremodules

import com.groundzero.asynclabs.features.employees.common.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityModule {
    @ContributesAndroidInjector(modules = [FragmentsModule::class])
    abstract fun contributeActivity(): MainActivity
}