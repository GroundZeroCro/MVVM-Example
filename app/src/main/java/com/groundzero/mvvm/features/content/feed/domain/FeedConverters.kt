package com.groundzero.mvvm.features.content.feed.domain

import androidx.room.TypeConverter
import com.google.gson.Gson

class FeedConverters {

    private val gson = Gson()

    @TypeConverter
    fun fromAuthorToString(author: Feed.Author): String = gson.toJson(author)

    @TypeConverter
    fun fromStringToAuthor(authorS: String): Feed.Author = gson.fromJson(authorS, Feed.Author::class.java)

    @TypeConverter
    fun fromVideoToString(video: Feed.Video): String = gson.toJson(video)

    @TypeConverter
    fun fromStringToVideo(videoS: String): Feed.Video = gson.fromJson(videoS, Feed.Video::class.java)
}