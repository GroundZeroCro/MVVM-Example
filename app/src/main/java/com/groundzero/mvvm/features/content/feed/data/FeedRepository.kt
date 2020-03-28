package com.groundzero.mvvm.features.content.feed.data

import com.groundzero.mvvm.data.resultLiveDataRemote
import javax.inject.Inject

class FeedRepository @Inject constructor(
    private val feedDataSource: FeedDataSource
) {
    val feed = resultLiveDataRemote(
        networkCall = { feedDataSource.feed() }
    )
}