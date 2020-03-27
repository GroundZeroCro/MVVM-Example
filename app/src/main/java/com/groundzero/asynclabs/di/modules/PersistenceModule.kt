package com.groundzero.asynclabs.di.modules

import android.app.Application
import com.groundzero.asynclabs.data.PersistenceDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class PersistenceModule {

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