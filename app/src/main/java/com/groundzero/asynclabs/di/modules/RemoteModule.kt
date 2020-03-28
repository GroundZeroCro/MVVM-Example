package com.groundzero.asynclabs.di.modules

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.groundzero.asynclabs.features.authentication.common.api.AuthenticationApi
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class RemoteModule {

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
    fun provideOkHttpClient(interceptor: HttpLoggingInterceptor): OkHttpClient =
        OkHttpClient.Builder().addNetworkInterceptor(interceptor).build()

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