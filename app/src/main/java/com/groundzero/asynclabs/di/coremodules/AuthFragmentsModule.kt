package com.groundzero.asynclabs.di.coremodules

import com.groundzero.asynclabs.features.authentication.login.LoginFragment
import com.groundzero.asynclabs.features.authentication.registration.RegistrationFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class AuthFragmentsModule {
    @ContributesAndroidInjector
    abstract fun contributeLoginFragment(): LoginFragment

    @ContributesAndroidInjector
    abstract fun contributeRegistrationFragment(): RegistrationFragment
}