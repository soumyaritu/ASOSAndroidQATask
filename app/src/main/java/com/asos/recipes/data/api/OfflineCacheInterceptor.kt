/*
 * By Martin Chamarro for ASOS
 * Copyright 2018 Martin Chamarro (@martinchamarro)
 */

package com.asos.recipes.data.api

import android.content.Context
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

class OfflineCacheInterceptor(private val context: Context) : Interceptor {

    companion object {
        const val CACHE_HEADER = "Cache-Control"
        const val CACHE_HEADER_IF_NOT_CONNECTED = "public, only-if-cached, max-stale=2419200"
    }

    override fun intercept(chain: Interceptor.Chain): Response {
        var request = chain.request()
        if (!hasConnection() && containsCacheHeader(request)) {
            request = request.newBuilder()
                    .header(CACHE_HEADER, CACHE_HEADER_IF_NOT_CONNECTED)
                    .build()
        }
        return chain.proceed(request)
    }

    private fun containsCacheHeader(request: Request) = request.header(CACHE_HEADER) != null

    private fun hasConnection() = NetworkChecker.isAvailable(context)
}