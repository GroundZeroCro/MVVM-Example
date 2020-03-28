package com.groundzero.mvvm.features.authentication.common.persistance

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


    @Query("SELECT * FROM token")
    fun getTokenSync(): Token?

    @Query("DELETE FROM token")
    suspend fun delete()
}