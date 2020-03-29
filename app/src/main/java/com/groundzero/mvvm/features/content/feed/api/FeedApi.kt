package com.groundzero.mvvm.features.content.feed.api

import retrofit2.Response
import retrofit2.http.GET

interface FeedApi {

    // TODO implement pagination
    @GET("feed?page=1&sport=football")
    suspend fun getFeed(): Response<List<FeedResponse>>
}