package com.groundzero.asynclabs.features.employees.data

import com.groundzero.asynclabs.data.resultLiveData
import javax.inject.Inject


class EmployeesRepository @Inject constructor(private val dataSource: EmployeesDataSource) {
    val employees = resultLiveData(networkCall = {dataSource.fetchEmployees()})
}