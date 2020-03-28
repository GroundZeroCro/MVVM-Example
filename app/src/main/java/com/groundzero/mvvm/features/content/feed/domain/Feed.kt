package com.groundzero.mvvm.features.content.feed.domain

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.groundzero.mvvm.features.content.feed.api.FeedResponse

@Entity(tableName = "feeds")
data class Feed(
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    val description: String,
    val views: String,
    @TypeConverters(FeedConverters::class)
    val author: Author,
    @TypeConverters(FeedConverters::class)
    val video: Video
) {
    data class Author(
        val id: Int,
        val name: String
    )

    data class Video(
        val handler: String,
        val url: String,
        val poster: String,
        val type: String,
        val length: Int
    )

    companion object {
        fun toFeed(feedsResponse: List<FeedResponse>): List<Feed> =
            feedsResponse.map {
                Feed(
                    it.id,
                    it.description,
                    it.views,
                    Author(
                        it.author.id,
                        it.author.name
                    ),
                    Video(
                        it.video.handler,
                        it.video.url,
                        it.video.poster,
                        it.video.type,
                        it.video.length
                    )
                )
            }
    }
}