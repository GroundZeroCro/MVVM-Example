package com.groundzero.mvvm.ui

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

@BindingAdapter("setImage")
fun ImageView.setImage(imgUrl: String?) {
    if (imgUrl != null)
        Glide.with(this.context)
            .load(imgUrl)
            .into(this)
}