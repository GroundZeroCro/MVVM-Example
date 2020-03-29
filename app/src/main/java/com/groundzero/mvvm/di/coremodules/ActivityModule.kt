package com.groundzero.mvvm.di.coremodules

import com.groundzero.mvvm.features.authentication.common.base.AuthenticationActivity
import com.groundzero.mvvm.features.content.common.base.ContentActivity
import com.groundzero.mvvm.features.landing.LandingActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityModule {

    @ContributesAndroidInjector(modules = [AuthFragmentsModule::class])
    abstract fun contributeAuthActivity(): AuthenticationActivity

    @ContributesAndroidInjector(modules = [FeedFragmentsModule::class])
    abstract fun contributeFeedActivity(): ContentActivity

    @ContributesAndroidInjector
    abstract fun contributeLandingActivity(): LandingActivity
}