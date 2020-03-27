package com.groundzero.asynclabs.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.groundzero.asynclabs.features.authentication.persistance.Token
import com.groundzero.asynclabs.features.authentication.persistance.TokenDao
import com.groundzero.asynclabs.features.authentication.persistance.User
import com.groundzero.asynclabs.features.authentication.persistance.UserDao

@Database(
    entities = [User::class, Token::class],
    exportSchema = false,
    version = 1
)
abstract class PersistenceDatabase : RoomDatabase() {

    abstract fun getUserDao(): UserDao
    abstract fun getTokenDao(): TokenDao

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