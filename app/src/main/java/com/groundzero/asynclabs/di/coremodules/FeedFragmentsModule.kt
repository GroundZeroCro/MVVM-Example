package com.groundzero.asynclabs.di.coremodules

import com.groundzero.asynclabs.features.content.feed.ui.FeedFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FeedFragmentsModule {

    @ContributesAndroidInjector
    abstract fun contributeFeedFragment(): FeedFragment
}