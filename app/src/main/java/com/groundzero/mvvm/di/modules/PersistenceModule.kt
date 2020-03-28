package com.groundzero.mvvm.di.modules

import android.app.Application
import com.groundzero.mvvm.data.PersistenceDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class PersistenceModule {

    @Singleton
    @Provides
    fun provideFeedDao(persistenceDatabase: PersistenceDatabase) =persistenceDatabase.getFeedDao()

    @Singleton
    @Provides
    fun provideUserDao(persistenceDatabase: PersistenceDatabase) =persistenceDatabase.getUserDao()

    @Singleton
    @Provides
    fun provideTokenDao(persistenceDatabase: PersistenceDatabase) =persistenceDatabase.getTokenDao()

    @Provides
    @Singleton
    fun providePersistenceDatabase(app: Application) = PersistenceDatabase.getInstance(app)
}