/*
 * By Martin Chamarro for ASOS
 * Copyright 2018 Martin Chamarro (@martinchamarro)
 */

package com.asos.recipes.presentation.ui.detail.views

import android.annotation.SuppressLint
import android.content.Context
import android.support.v4.widget.TextViewCompat
import android.util.AttributeSet
import android.widget.TextView
import com.asos.recipes.R
import com.asos.recipes.presentation.extensions.dimen
import com.asos.recipes.presentation.extensions.string

@SuppressLint("AppCompatCustomView")
@Suppress("DEPRECATION")
class InstructionView : TextView {

    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    init {
        val topPadding = context.dimen(R.dimen.normal_padding)
        val horizontalPadding = context.dimen(R.dimen.small_padding)
        setPadding(horizontalPadding, topPadding, horizontalPadding, 0)
        TextViewCompat.setTextAppearance(this, R.style.DetailInstructionStyle)
    }

    fun render(position: Int, step: String) {
        text = string(R.string.detail_step).format(position+1, step)
    }

}