package com.groundzero.mvvm.features.content.feed.data

import com.groundzero.mvvm.data.resultLiveDataPersistant
import com.groundzero.mvvm.features.content.feed.domain.Feed
import com.groundzero.mvvm.features.content.feed.domain.FeedDao
import javax.inject.Inject

class FeedRepository @Inject constructor(
    private val feedDataSource: FeedDataSource,
    private val feedDao: FeedDao
) {
    /**
     * Fetching remote data then mapping it to domain object. After successful fetch
     * data is stored to SQLite database and observed with LiveData.
     */
    val feed = resultLiveDataPersistant(
        networkCall = { feedDataSource.feed() },
        saveLocal = { feedDao.insert(Feed.toFeed(it)) },
        observeLocal = { feedDao.getFeed() }
    )
}