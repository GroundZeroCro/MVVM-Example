package com.groundzero.mvvm.features.content.feed.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.groundzero.mvvm.base.BaseFragment
import com.groundzero.mvvm.databinding.FragmentFeedBinding
import com.groundzero.mvvm.di.helper.injectViewModel

class FeedFragment : BaseFragment() {

    private lateinit var viewModel: FeedViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = FragmentFeedBinding.inflate(inflater, container, false).apply {
        viewModel = injectViewModel(viewModelFactory)
        viewModel.feed.observe(viewLifecycleOwner, Observer {
            println(it)
        })
    }.root
}
