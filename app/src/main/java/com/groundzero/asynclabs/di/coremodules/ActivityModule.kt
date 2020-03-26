package com.groundzero.asynclabs.di.coremodules

import com.groundzero.asynclabs.features.authentication.common.AuthenticationActivity
import com.groundzero.asynclabs.features.employees.common.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityModule {

    @ContributesAndroidInjector(modules = [MainFragmentsModule::class])
    abstract fun contributeActivity(): MainActivity

    @ContributesAndroidInjector(modules = [AuthFragmentsModule::class])
    abstract fun contributeAuthActivity(): AuthenticationActivity
}