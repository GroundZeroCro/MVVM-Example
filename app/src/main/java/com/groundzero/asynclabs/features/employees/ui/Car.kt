package com.groundzero.asynclabs.features.employees.ui

import javax.inject.Inject

// Dagger injection test if remote data not fetched
class Car @Inject constructor() {
    fun name(): String = "Ferrari"
}