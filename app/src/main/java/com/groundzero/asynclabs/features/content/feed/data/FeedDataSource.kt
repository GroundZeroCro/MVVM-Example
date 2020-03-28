package com.groundzero.asynclabs.features.content.feed.data

import com.groundzero.asynclabs.api.BaseDataSource
import com.groundzero.asynclabs.features.content.feed.api.FeedApi
import javax.inject.Inject

class FeedDataSource @Inject constructor(private val feedApi: FeedApi) : BaseDataSource() {
    suspend fun feed() = getResult { feedApi.getFeed() }
}