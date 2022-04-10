/*
 * By Martin Chamarro for ASOS
 * Copyright 2018 Martin Chamarro (@martinchamarro)
 */

package com.asos.recipes.data.api

import android.content.Context
import com.google.gson.GsonBuilder
import com.asos.recipes.Config
import com.asos.recipes.globalutils.logger.Logger
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject

class RetrofitServicesFactory @Inject constructor(
        private val context: Context,
        private val logger: Logger) {

    fun create(): Services {
        val retrofit = getHttpAdapter()
        return retrofit.create(Services::class.java)
    }

    private fun getHttpAdapter(): Retrofit {
        return Retrofit.Builder()
                .baseUrl(Config.API_DOMAIN)
                .addConverterFactory(getGsonConverter())
                .client(createClient())
                .build()
    }

    /*
     * This is the place to register type adapters
     */
    private fun getGsonConverter(): GsonConverterFactory {
        val gsonBuilder = GsonBuilder()
        val gson = gsonBuilder.create()
        return GsonConverterFactory.create(gson)
    }

    private fun createClient(): OkHttpClient {
        return OkHttpClient.Builder()
                .cache(CacheFactory.create(context))
                .addInterceptor(OfflineCacheInterceptor(context))
                .addInterceptor(createLoggingInterceptor())
                .build()
    }

    private fun createLoggingInterceptor(): HttpLoggingInterceptor {
        val interceptor = HttpLoggingInterceptor(HttpLoggingInterceptor.Logger { logger.l(it) })
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        return interceptor
    }

}
