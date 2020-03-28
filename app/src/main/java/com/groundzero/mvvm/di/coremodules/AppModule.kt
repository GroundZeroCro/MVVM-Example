package com.groundzero.mvvm.di.coremodules

import com.groundzero.mvvm.di.modules.PersistenceModule
import com.groundzero.mvvm.di.modules.RemoteModule
import com.groundzero.mvvm.di.modules.ViewModelModule
import dagger.Module

@Module(includes = [RemoteModule::class, ViewModelModule::class, PersistenceModule::class])
interface AppModule