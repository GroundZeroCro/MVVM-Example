package com.groundzero.asynclabs.di.coremodules

import com.groundzero.asynclabs.di.modules.RemoteModule
import com.groundzero.asynclabs.di.modules.ViewModelModule
import dagger.Module

@Module(includes = [RemoteModule::class, ViewModelModule::class])
interface AppModule