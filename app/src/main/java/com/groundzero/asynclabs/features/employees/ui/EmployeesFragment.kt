package com.groundzero.asynclabs.features.employees.ui


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.groundzero.asynclabs.base.BaseFragment
import com.groundzero.asynclabs.databinding.FragmentRandomBinding
import com.groundzero.asynclabs.di.helper.injectViewModel
import javax.inject.Inject

class EmployeesFragment : BaseFragment() {
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    @Inject
    lateinit var car: Car

    private lateinit var viewModel: EmployeesViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentRandomBinding.inflate(inflater, container, false)
        viewModel = injectViewModel(viewModelFactory)
        viewModel.employeesLive.observe(this, Observer { t -> println(t.data) })
        println(car.name())
        return binding.root
    }
}
