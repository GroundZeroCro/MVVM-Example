package com.groundzero.asynclabs.features.authentication.persistance

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface TokenDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(token: Token)

    @Query("SELECT * FROM token")
    fun getToken(): LiveData<Token>

    @Query("DELETE FROM token")
    suspend fun delete()
}