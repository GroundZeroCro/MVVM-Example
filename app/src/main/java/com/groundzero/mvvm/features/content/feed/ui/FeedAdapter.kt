package com.groundzero.mvvm.features.content.feed.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.groundzero.mvvm.databinding.ItemFeedBinding
import com.groundzero.mvvm.features.content.feed.domain.Feed
import kotlinx.android.synthetic.main.item_feed.view.*

class FeedAdapter(private val listener: FeedListener) :
    ListAdapter<Feed, FeedAdapter.FeedViewHolder>(DIFF_CALLBACK) {

    class FeedViewHolder(private val binding: ItemFeedBinding, private val listener: FeedListener) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(feed: Feed) {
            binding.feed = feed
            itemView.setOnClickListener { listener.onItemClick(feed) }
            itemView.item_author.setOnClickListener{ listener.onUserClick(feed.author.id)}
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FeedViewHolder =
        FeedViewHolder(
            ItemFeedBinding.inflate(LayoutInflater.from(parent.context), parent, false),
            listener
        )

    override fun onBindViewHolder(holder: FeedViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    companion object {
        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Feed>() {
            override fun areItemsTheSame(oldItem: Feed, newItem: Feed): Boolean =
                oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: Feed, newItem: Feed): Boolean =
                oldItem == newItem
        }
    }
}