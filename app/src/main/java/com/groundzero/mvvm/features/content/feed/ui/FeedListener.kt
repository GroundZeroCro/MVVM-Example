package com.groundzero.mvvm.features.content.feed.ui

import com.groundzero.mvvm.features.content.feed.domain.Feed

interface FeedListener {
    fun onItemClick(feed: Feed)
    fun onUserClick(itemId: Int)
}