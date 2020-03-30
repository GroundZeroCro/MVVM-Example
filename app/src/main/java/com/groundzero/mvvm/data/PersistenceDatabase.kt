package com.groundzero.mvvm.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.groundzero.mvvm.features.authentication.common.domain.Token
import com.groundzero.mvvm.features.authentication.common.domain.TokenDao
import com.groundzero.mvvm.features.authentication.common.domain.User
import com.groundzero.mvvm.features.authentication.common.domain.UserDao
import com.groundzero.mvvm.features.content.feed.domain.Feed
import com.groundzero.mvvm.features.content.feed.domain.FeedConverters
import com.groundzero.mvvm.features.content.feed.domain.FeedDao
import com.groundzero.mvvm.features.content.profile.domain.Profile
import com.groundzero.mvvm.features.content.profile.domain.ProfileDao

@TypeConverters(
    FeedConverters::class
)
@Database(
    entities = [User::class, Token::class, Feed::class, Profile::class],
    exportSchema = false,
    version = 1
)
abstract class PersistenceDatabase : RoomDatabase() {

    abstract fun getUserDao(): UserDao
    abstract fun getTokenDao(): TokenDao
    abstract fun getFeedDao(): FeedDao
    abstract fun getProfileDao(): ProfileDao

    companion object {

        @Volatile
        private var instance: PersistenceDatabase? = null

        fun getInstance(
            context: Context
        ): PersistenceDatabase =
            instance
                ?: buildDatabase(
                    context
                ).also { instance = it }

        private fun buildDatabase(
            context: Context
        ): PersistenceDatabase {

            return Room.databaseBuilder(
                context, PersistenceDatabase::class.java,
                DATABASE_NAME
            )
                .build()
        }

        private const val DATABASE_NAME = "my_database"

    }
}