/*
 * By Martin Chamarro for ASOS
 * Copyright 2018 Martin Chamarro (@martinchamarro)
 */

package com.asos.recipes.presentation.extensions

import android.app.Activity
import android.content.Context
import android.view.View
import com.asos.recipes.AndroidApplication
import com.asos.recipes.presentation.di.ActivityComponent
import com.asos.recipes.presentation.di.DaggerActivityComponent
import com.asos.recipes.presentation.di.ActivityModule

fun Activity.fullScreen() {
    window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
}

val Activity.context: Context get() = this

val Activity.activityComponent: ActivityComponent
    get() = DaggerActivityComponent.builder()
            .applicationComponent((application as AndroidApplication).applicationComponent)
            .activityModule(ActivityModule(this))
            .build()