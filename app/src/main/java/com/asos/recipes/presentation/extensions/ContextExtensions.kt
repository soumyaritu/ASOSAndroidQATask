/*
 * By Martin Chamarro for ASOS
 * Copyright 2018 Martin Chamarro (@martinchamarro)
 */

package com.asos.recipes.presentation.extensions

import android.content.Context
import android.support.annotation.*
import android.support.v4.content.ContextCompat
import android.view.View

fun Context.string(@StringRes stringRes: Int): String = getString(stringRes)

fun Context.dimen(@DimenRes dimenRes: Int) = resources.getDimensionPixelSize(dimenRes)

fun Context.integer(@IntegerRes integerRes: Int) = resources.getInteger(integerRes)

fun Context.color(@ColorRes colorRes: Int): Int = ContextCompat.getColor(this, colorRes)

fun Context.layout(@LayoutRes layoutRes: Int): View = View.inflate(this, layoutRes, null)