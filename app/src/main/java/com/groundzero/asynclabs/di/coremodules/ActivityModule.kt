package com.groundzero.asynclabs.di.coremodules

import com.groundzero.asynclabs.features.authentication.base.AuthenticationActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityModule {

    @ContributesAndroidInjector(modules = [AuthFragmentsModule::class])
    abstract fun contributeAuthActivity(): AuthenticationActivity
}