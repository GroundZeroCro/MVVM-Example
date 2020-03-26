package com.groundzero.asynclabs.features.employees.data

import com.groundzero.asynclabs.api.BaseDataSource
import com.groundzero.asynclabs.api.EmployeesApi
import javax.inject.Inject

class EmployeesDataSource @Inject constructor(private val api: EmployeesApi): BaseDataSource() {
    suspend fun fetchEmployees() = getResult{api.getData()}
}