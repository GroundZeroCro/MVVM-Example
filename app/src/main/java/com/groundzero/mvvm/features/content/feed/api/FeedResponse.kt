package com.groundzero.mvvm.features.content.feed.api

data class FeedResponse(
    val id: Int,
    val description: String,
    val views: String,
    val author: Author,
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
}
