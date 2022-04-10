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
import com.asos.recipes.domain.model.DifficultyFilter

class DifficultySpinner : AppCompatSpinner {

    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    init {
        val adapter = ArrayAdapter.createFromResource(context, R.array.recipe_difficulties, R.layout.item_spinner)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        this.adapter = adapter
    }

    fun getSelected(): DifficultyFilter = when(selectedItemPosition) {
        1 -> DifficultyFilter.Easy
        2 -> DifficultyFilter.Medium
        3 -> DifficultyFilter.Hard
        else -> DifficultyFilter.All
    }

}