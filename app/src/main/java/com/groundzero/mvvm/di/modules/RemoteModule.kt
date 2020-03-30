package com.groundzero.mvvm.di.modules

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.groundzero.mvvm.features.authentication.common.api.AuthenticationApi
import com.groundzero.mvvm.features.authentication.common.domain.TokenDao
import com.groundzero.mvvm.features.content.feed.api.FeedApi
import com.groundzero.mvvm.features.content.profile.api.ProfileApi
import dagger.Module
import dagger.Provides
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class RemoteModule {

    @Provides
    @Singleton
    fun provideProfileApi(
        client: OkHttpClient,
        converterFactory: GsonConverterFactory
    ) = createApi(client, converterFactory, ProfileApi::class.java)

    @Provides
    @Singleton
    fun provideFeedApi(
        client: OkHttpClient,
        converterFactory: GsonConverterFactory
    ) = createApi(client, converterFactory, FeedApi::class.java)

    @Provides
    @Singleton
    fun provideAuthenticationApi(
        client: OkHttpClient,
        converterFactory: GsonConverterFactory
    ) = createApi(client, converterFactory, AuthenticationApi::class.java)

    private fun <T> createApi(
        client: OkHttpClient,
        converterFactory: GsonConverterFactory,
        clazz: Class<T>
    ): T =
        createRetrofit(client, converterFactory).create(clazz)

    private fun createRetrofit(
        client: OkHttpClient,
        converterFactory: GsonConverterFactory
    ): Retrofit =
        Retrofit.Builder()
            .addConverterFactory(converterFactory)
            .client(client)
            .baseUrl(BASE_URL)
            .build()

    @Provides
    fun provideOkHttpClient(interceptor: HttpLoggingInterceptor, tokenDao: TokenDao): OkHttpClient =
        OkHttpClient.Builder()
            .addInterceptor(
                Interceptor {
                    val builder = it.request().newBuilder()
                    // During initial app opening device does not contain stored token
                    val token: String? = tokenDao.getTokenSync()?.token
                    token?.let {
                        builder.header("Accept-Language", "en")
                        builder.header("Authorization", "Bearer ${tokenDao.getTokenSync()!!.token}")
                    }
                    return@Interceptor it.proceed(builder.build())
                }
            )
            .addNetworkInterceptor(interceptor).build()

    @Provides
    fun provideLoggingInterceptor() =
        HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY }

    @Singleton
    @Provides
    fun provideGson(): Gson = GsonBuilder().setLenient().create()

    @Singleton
    @Provides
    fun provideGsonConverter(): GsonConverterFactory = GsonConverterFactory.create()

    companion object {
        const val BASE_URL = "https://private-anon-145357f057-technicaltaskapi.apiary-mock.com/"
    }
}