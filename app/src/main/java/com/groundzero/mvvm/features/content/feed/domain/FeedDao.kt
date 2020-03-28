package com.groundzero.mvvm.features.content.feed.domain

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface FeedDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(feeds: List<Feed>)

    @Query("SELECT * FROM feeds")
    fun getFeed(): LiveData<List<Feed>>
}