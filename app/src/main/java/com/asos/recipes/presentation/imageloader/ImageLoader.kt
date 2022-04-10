/*
 * By Martin Chamarro for ASOS
 * Copyright 2018 Martin Chamarro (@martinchamarro)
 */

package com.asos.recipes.presentation.imageloader

import android.content.Context
import android.support.annotation.DrawableRes
import android.widget.ImageView
import com.jakewharton.picasso.OkHttp3Downloader
import com.squareup.picasso.Picasso

class ImageLoader private constructor(context: Context){

    companion object {
        private var instance: ImageLoader? = null
        fun with(context: Context): ImageLoader {
            instance = instance ?: ImageLoader(context)
            return instance!!
        }
    }

    private var picasso: Picasso = Picasso.Builder(context)
            .downloader(OkHttp3Downloader(context))
            .build()

    fun load(imageView: ImageView, url: String?, @DrawableRes placeholder: Int = -1) {
        if (placeholder != -1) imageView.setImageResource(placeholder)
        if (url.isNullOrBlank()) return
        val request = picasso.load(url)
        if (placeholder != -1) {
            request.placeholder(placeholder)
            request.error(placeholder)
        }
        request.into(imageView)
    }
}