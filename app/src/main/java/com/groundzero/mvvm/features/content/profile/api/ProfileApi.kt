package com.groundzero.mvvm.features.content.profile.api

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ProfileApi {

    @GET("user/{id}")
    suspend fun getUserProfile(
        @Path("id") userId: Int
    ): Response<ProfileResponse>
}