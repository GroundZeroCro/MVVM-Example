package com.groundzero.asynclabs.di.modules

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.groundzero.asynclabs.di.helper.ViewModelFactory
import com.groundzero.asynclabs.di.scopes.ViewModelKey
import com.groundzero.asynclabs.features.employees.ui.EmployeesViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(EmployeesViewModel::class)
    abstract fun bindEmployeesViewModel(viewModel: EmployeesViewModel): ViewModel

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}