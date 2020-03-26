package com.groundzero.asynclabs.di.coremodules

import com.groundzero.asynclabs.features.employees.ui.EmployeesFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentsModule {
    @ContributesAndroidInjector
    abstract fun contributeEmployeesFragment(): EmployeesFragment
}