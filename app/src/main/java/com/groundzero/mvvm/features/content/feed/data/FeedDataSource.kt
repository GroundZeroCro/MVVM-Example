package com.groundzero.mvvm.features.content.feed.data

import com.groundzero.mvvm.api.BaseDataSource
import com.groundzero.mvvm.features.content.feed.api.FeedApi
import javax.inject.Inject

class FeedDataSource @Inject constructor(private val feedApi: FeedApi) : BaseDataSource() {
    suspend fun feed() = getResult { feedApi.getFeed() }
}