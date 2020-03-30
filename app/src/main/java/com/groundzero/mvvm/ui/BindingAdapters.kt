package com.groundzero.mvvm.ui

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.groundzero.mvvm.R

@BindingAdapter("setImage")
fun ImageView.setImage(imgUrl: String?) {
    if (imgUrl != null)
        Glide.with(this.context)
            .load(imgUrl)
            .into(this)
}


@BindingAdapter("setGoogleDriveAvatar")
fun ImageView.setAvatar(imgUrl: String?) {
    if (imgUrl != null)
        Glide.with(this.context)
            .load(fixedUrl(imgUrl))
            .apply(RequestOptions.circleCropTransform())
            .into(this)
}

fun fixedUrl(imgUrl: String?) =
    imgUrl?.replace("https://drive.google.com/open?id=", "https://docs.google.com/uc?id=")