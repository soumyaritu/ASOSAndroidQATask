/*
 * By Martin Chamarro for ASOS
 * Copyright 2018 Martin Chamarro (@martinchamarro)
 */

package com.asos.recipes.presentation.ui.home.views

import android.content.Context
import android.support.v7.widget.AppCompatSpinner
import android.util.AttributeSet
import android.widget.ArrayAdapter
import com.asos.recipes.R
import com.asos.recipes.domain.model.PreparationTimeFilter

class PreparationTimeSpinner : AppCompatSpinner {

    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    init {
        val adapter = ArrayAdapter.createFromResource(context, R.array.recipe_preparation_times, R.layout.item_spinner)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        this.adapter = adapter
    }

    fun getSelected(): PreparationTimeFilter = when(selectedItemPosition) {
        1 -> PreparationTimeFilter.Fast
        2 -> PreparationTimeFilter.Medium
        3 -> PreparationTimeFilter.Slow
        else -> PreparationTimeFilter.All
    }

}