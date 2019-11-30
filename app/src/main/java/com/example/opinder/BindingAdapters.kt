package com.example.opinder.network

import android.widget.ImageView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.opinder.R

@BindingAdapter("imageUrl")
fun bindImage(imageView: ImageView, imageId: String?) {
    imageId?.let {
        val imageBaseUrl = "https://api.opinder.xyz/images/$imageId"
        val imageUri = imageBaseUrl.toUri().buildUpon().scheme("https").build()
        Glide.with(imageView.context)
            .load(imageUri)
            .apply(RequestOptions().placeholder(R.drawable.loading_animation)
                .error(R.drawable.broken_image))
            .into(imageView)
    }
}