package com.groundzero.mvvm.features.content.video.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.groundzero.mvvm.base.BaseFragment
import com.groundzero.mvvm.databinding.FragmentVideoBinding
import com.groundzero.mvvm.features.content.video.domain.VideoPlayer
import javax.inject.Inject


class VideoFragment : BaseFragment() {

    private val args: VideoFragmentArgs by navArgs()

    @Inject
    lateinit var moviePlayer: VideoPlayer

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = FragmentVideoBinding.inflate(inflater).apply {
        moviePlayer.preparePlayer(args.feed.video.url)
        videoPlayer.player = moviePlayer.player
    }.root

    override fun onDestroy() {
        super.onDestroy()
        moviePlayer.onDestroy()
    }
}
