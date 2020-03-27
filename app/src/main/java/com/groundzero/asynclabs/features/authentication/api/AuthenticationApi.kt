package com.groundzero.asynclabs.features.authentication.api

import retrofit2.Response
import retrofit2.http.POST

interface AuthenticationApi {

    @POST("registration")
    suspend fun registerUser(): Response<RegistrationResponse>

    @POST("login")
    suspend fun loginUser(): Response<LoginResponse>
}