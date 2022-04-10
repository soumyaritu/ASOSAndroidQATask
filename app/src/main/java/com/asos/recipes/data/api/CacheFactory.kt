/*
 * By Martin Chamarro for ASOS
 * Copyright 2018 Martin Chamarro (@martinchamarro)
 */

package com.asos.recipes.data.api

import android.content.Context
import okhttp3.Cache
import java.io.File

class CacheFactory {

    companion object {

        private const val DEFAULT_SIZE: Long = 10 * 1024 * 1024 // 10 MB
        private const val DEFAULT_DIR: String = "cache"

        fun create(
                context: Context,
                size: Long = DEFAULT_SIZE,
                directory: File = File(context.cacheDir, DEFAULT_DIR)): Cache {
            return Cache(directory, size)
        }

    }
}