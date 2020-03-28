package com.groundzero.mvvm.features.content.video.domain

import android.app.Application
import android.net.Uri
import com.google.android.exoplayer2.SimpleExoPlayer
import com.google.android.exoplayer2.source.ProgressiveMediaSource
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory
import com.google.android.exoplayer2.util.Util
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class VideoPlayer @Inject constructor(private val context: Application) {

    var player: SimpleExoPlayer = SimpleExoPlayer.Builder(context).build()

    fun preparePlayer(url: String) {
        player.prepare(getMediaSource(url))
        player.playWhenReady = true
    }

    private fun getMediaSource(url: String): ProgressiveMediaSource {
        return ProgressiveMediaSource.Factory(getDataSource()).createMediaSource(Uri.parse(url))
    }

    private fun getDataSource(): DefaultDataSourceFactory {
        return DefaultDataSourceFactory(context, Util.getUserAgent(context, "yourApplicationName"))
    }

    fun onDestroy() {
        player.stop()
    }
}