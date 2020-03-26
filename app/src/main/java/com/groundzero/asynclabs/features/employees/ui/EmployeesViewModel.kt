package com.groundzero.asynclabs.features.employees.ui

import androidx.lifecycle.ViewModel
import com.groundzero.asynclabs.features.employees.data.EmployeesRepository
import javax.inject.Inject

class EmployeesViewModel @Inject constructor(repository: EmployeesRepository) : ViewModel() {
    val employeesLive = repository.employees
}