package com.groundzero.mvvm.ui

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import java.text.SimpleDateFormat
import java.util.*

@BindingAdapter("setImage")
fun ImageView.setImage(imgUrl: String?) {
    if (imgUrl != null)
        Glide.with(this.context)
            .load(imgUrl)
            .into(this)
}