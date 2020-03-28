package com.groundzero.mvvm.di.coremodules

import com.groundzero.mvvm.features.content.feed.ui.FeedFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FeedFragmentsModule {

    @ContributesAndroidInjector
    abstract fun contributeFeedFragment(): FeedFragment
}