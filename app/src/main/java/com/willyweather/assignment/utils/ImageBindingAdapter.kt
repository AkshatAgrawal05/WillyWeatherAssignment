package com.willyweather.assignment.utils

import android.net.Uri
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.github.twocoffeesoneteam.glidetovectoryou.GlideToVectorYou

class ImageBindingAdapter {

    companion object {

        @JvmStatic
        @BindingAdapter("imageUrl")
        fun loadImage(view: ImageView, url: String?) {
            GlideToVectorYou
                .init()
                .with(view.context)
                .load(Uri.parse(url), view)
        }
    }
}