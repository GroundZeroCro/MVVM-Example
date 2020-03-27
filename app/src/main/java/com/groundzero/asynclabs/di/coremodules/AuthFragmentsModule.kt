package com.groundzero.asynclabs.di.coremodules

import com.groundzero.asynclabs.features.authentication.login.ui.LoginFragment
import com.groundzero.asynclabs.features.authentication.registration.ui.RegistrationFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class AuthFragmentsModule {
    @ContributesAndroidInjector
    abstract fun contributeLoginFragment(): LoginFragment

    @ContributesAndroidInjector
    abstract fun contributeRegistrationFragment(): RegistrationFragment
}