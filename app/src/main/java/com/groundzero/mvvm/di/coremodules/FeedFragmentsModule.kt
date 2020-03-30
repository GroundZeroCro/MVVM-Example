package com.groundzero.mvvm.di.coremodules

import com.groundzero.mvvm.features.content.video.ui.VideoFragment
import com.groundzero.mvvm.features.content.feed.ui.FeedFragment
import com.groundzero.mvvm.features.content.profile.ui.ProfileFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FeedFragmentsModule {

    @ContributesAndroidInjector
    abstract fun contributeFeedFragment(): FeedFragment

    @ContributesAndroidInjector
    abstract fun contributeVideoFragment(): VideoFragment

    @ContributesAndroidInjector
    abstract fun contributeProfileFragment(): ProfileFragment
}