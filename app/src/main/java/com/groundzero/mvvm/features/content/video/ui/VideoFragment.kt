package com.groundzero.mvvm.features.content.video.ui

import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.google.android.exoplayer2.SimpleExoPlayer
import com.google.android.exoplayer2.source.MediaSource
import com.google.android.exoplayer2.source.ProgressiveMediaSource
import com.google.android.exoplayer2.upstream.DataSource
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory
import com.google.android.exoplayer2.util.Util
import com.groundzero.mvvm.databinding.FragmentVideoBinding


class VideoFragment : Fragment() {

    private val args: VideoFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = FragmentVideoBinding.inflate(inflater).apply {
        val player = SimpleExoPlayer.Builder(requireContext()).build()
        videoPlayer.player = player

        val dataSourceFactory: DataSource.Factory = DefaultDataSourceFactory(
            requireContext(),
            Util.getUserAgent(requireContext(), "yourApplicationName")
        )
        val videoSource: MediaSource = ProgressiveMediaSource.Factory(dataSourceFactory)
            .createMediaSource(Uri.parse(args.feed.video.url))
        player.prepare(videoSource)


    }.root
}
