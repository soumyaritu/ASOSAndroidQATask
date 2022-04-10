/*
 * By Martin Chamarro for ASOS
 * Copyright 2018 Martin Chamarro (@martinchamarro)
 */

package com.asos.recipes.data.api

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo

object NetworkChecker {
    fun isAvailable(context: Context): Boolean {
        val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val network: NetworkInfo? = cm.activeNetworkInfo
        return network != null && network.isAvailable && network.isConnected
    }
}