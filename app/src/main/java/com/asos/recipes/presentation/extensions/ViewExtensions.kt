/*
 * By Martin Chamarro for ASOS
 * Copyright 2018 Martin Chamarro (@martinchamarro)
 */

package com.asos.recipes.presentation.extensions

import android.content.Context
import android.graphics.drawable.Drawable
import android.support.annotation.*
import android.support.v4.content.ContextCompat
import android.view.Menu
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import com.asos.recipes.presentation.imageloader.ImageLoader

val View.ctx: Context get() = context

fun View.visible() { visibility = View.VISIBLE }

fun View.invisible() { visibility = View.INVISIBLE }

fun View.gone() { visibility = View.GONE }

fun View.drawable(@DrawableRes drawableRes: Int): Drawable? = ContextCompat.getDrawable(ctx, drawableRes)

fun View.integer(@IntegerRes integerRes: Int) = ctx.integer(integerRes)

fun View.string(@StringRes stringRes: Int): String = context.getString(stringRes)

fun View.color(@ColorRes colorRes: Int): Int = context.color(colorRes)

fun ViewGroup.inflate(@LayoutRes layoutRes: Int, attach: Boolean = false) {
    View.inflate(context, layoutRes, if (attach) this else null)
}

fun ImageView.load(url: String?, @DrawableRes placeholderRes: Int = -1) {
    ImageLoader.with(context).load(this, url, placeholderRes)
}

val TextView.string: String get() = text.toString()

fun EditText.hideKeyboard() {
    val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    imm.hideSoftInputFromWindow(windowToken, 0)
}

fun EditText.showKeyboard() {
    requestFocus()
    val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    imm.toggleSoftInputFromWindow(applicationWindowToken, InputMethodManager.SHOW_FORCED, 0)
}

fun Menu.setVisible(visible: Boolean) {
    for (i in 0 until size()) getItem(i).isVisible = visible
}
