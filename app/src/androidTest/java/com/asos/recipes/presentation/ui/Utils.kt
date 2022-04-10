package com.asos.recipes.presentation.ui

import android.content.Context
import android.support.test.rule.ActivityTestRule
import com.asos.recipes.AndroidApplication
import com.asos.recipes.globalutils.di.ApplicationComponent

val ActivityTestRule<*>.context: Context get() = activity

val ActivityTestRule<*>.applicationComponent: ApplicationComponent
    get() = (context.applicationContext as AndroidApplication).applicationComponent

fun delay(millis: Long = 2000L) {
    try {
        Thread.sleep(millis)
    } catch (e: InterruptedException) { e.printStackTrace() }
}