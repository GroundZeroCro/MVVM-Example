package com.groundzero.asynclabs.di.coremodules

import com.groundzero.asynclabs.features.authentication.common.base.AuthenticationActivity
import com.groundzero.asynclabs.features.feed.FeedActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityModule {

    @ContributesAndroidInjector(modules = [AuthFragmentsModule::class])
    abstract fun contributeAuthActivity(): AuthenticationActivity

    @ContributesAndroidInjector(modules = [FeedFragmentsModule::class])
    abstract fun contributeFeedActivity(): FeedActivity
}