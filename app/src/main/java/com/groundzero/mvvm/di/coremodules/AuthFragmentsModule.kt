package com.groundzero.mvvm.di.coremodules

import com.groundzero.mvvm.features.authentication.login.ui.LoginFragment
import com.groundzero.mvvm.features.authentication.registration.ui.RegistrationFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class AuthFragmentsModule {
    @ContributesAndroidInjector
    abstract fun contributeLoginFragment(): LoginFragment

    @ContributesAndroidInjector
    abstract fun contributeRegistrationFragment(): RegistrationFragment
}