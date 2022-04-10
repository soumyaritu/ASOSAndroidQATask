/*
 * By Martin Chamarro for ASOS
 * Copyright 2018 Martin Chamarro (@martinchamarro)
 */

package com.asos.recipes.globalutils.logger

import android.util.Log
import com.asos.recipes.Config.APP_NAME
import com.asos.recipes.Config.DEBUG

object Logger {

    private val MESSAGE_LIMIT = 3 * 1024

    fun i(tag: String? = null, msg: String? = null) {
        if (DEBUG) Log.i(APP_NAME, getText(tag, msg))
    }

    fun e(tag: String? = null, msg: String? = null) {
        Log.e(APP_NAME, getText(tag, msg))
    }

    fun d(tag: String? = null, msg: String? = null) {
        if (DEBUG) Log.d(APP_NAME, getText(tag, msg))
    }

    fun v(tag: String? = null, msg: String? = null) {
        if (DEBUG) Log.v(APP_NAME, getText(tag, msg))
    }

    fun w(tag: String? = null, msg: String? = null) {
        if (DEBUG) Log.w(APP_NAME, getText(tag, msg))
    }

    fun wtf(tag: String? = null, msg: String? = null) {
        if (DEBUG) Log.wtf(APP_NAME, getText(tag, msg))
    }

    fun l(tag: String? = null, msg: String? = null) {
        if (!DEBUG) return
        var message = msg
        while (!message.isNullOrEmpty() && message!!.length > MESSAGE_LIMIT) {
            d(tag, message.substring(0, MESSAGE_LIMIT))
            message = message.substring(MESSAGE_LIMIT)
        }
        d(tag, message)
    }

    private fun getText(tag: String?, msg: String?): String {
        return if (tag.isNullOrEmpty()) "$msg" else "[$tag] $msg"
    }

}