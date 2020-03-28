package com.groundzero.mvvm.features.authentication.common.persistance

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(user: User)

    @Query("SELECT * FROM user")
    fun getUser(): LiveData<User>

    @Query("DELETE FROM user")
    suspend fun delete()
}