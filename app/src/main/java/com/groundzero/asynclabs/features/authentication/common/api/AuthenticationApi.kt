package com.groundzero.asynclabs.features.authentication.common.api

import retrofit2.Response
import retrofit2.http.POST
import retrofit2.http.Query

interface AuthenticationApi {

    @POST("registration")
    suspend fun registerUser(
        @Query("username") username: String,
        @Query("email") email: String,
        @Query("password") password: String
    ): Response<RegistrationResponse>

    @POST("login")
    suspend fun loginUser(
        @Query("username") username: String,
        @Query("password") password: String
    ): Response<LoginResponse>
}