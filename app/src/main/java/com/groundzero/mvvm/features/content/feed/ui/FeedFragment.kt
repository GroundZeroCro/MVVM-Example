package com.groundzero.mvvm.features.content.feed.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.groundzero.mvvm.R
import com.groundzero.mvvm.base.BaseFragment
import com.groundzero.mvvm.data.Result
import com.groundzero.mvvm.databinding.FragmentFeedBinding
import com.groundzero.mvvm.di.helper.injectViewModel
import com.groundzero.mvvm.features.content.feed.domain.Feed

class FeedFragment : BaseFragment(), FeedListener {

    private lateinit var viewModel: FeedViewModel
    private var feedAdapter: FeedAdapter = FeedAdapter(this)


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = FragmentFeedBinding.inflate(inflater, container, false).apply {
        feedRecyclerView.adapter = feedAdapter
        viewModel = injectViewModel(viewModelFactory)
        viewModel.feed.observe(viewLifecycleOwner, Observer {

            when (it.status) {
                Result.Status.LOADING ->
                    progressDialog.showDialog(
                        requireContext(),
                        requireContext().getString(R.string.progress_bar_loading_feed)
                    )
                Result.Status.SUCCESS -> {
                    progressDialog.cancelDialog()
                    feedAdapter.submitList(it.data)
                }
                Result.Status.ERROR -> {
                }
            }
        })
    }.root

    override fun onItemClick(feed: Feed) {
        val action = FeedFragmentDirections.actionFeedFragmentToVideoFragment(feed)
        findNavController().navigate(action)
    }
}
