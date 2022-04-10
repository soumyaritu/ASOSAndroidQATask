/*
 * By Martin Chamarro for ASOS
 * Copyright 2018 Martin Chamarro (@martinchamarro)
 */

package com.asos.recipes.presentation.ui.detail.views

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.LinearLayout
import com.asos.recipes.R
import com.asos.recipes.domain.model.Ingredient
import com.asos.recipes.presentation.extensions.dimen
import kotlinx.android.synthetic.main.item_ingredient.view.*

class IngredientView : LinearLayout {

    constructor(context: Context?) : super(context)
    constructor(context: Context?, ingredient: Ingredient) : super(context) { render(ingredient) }
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    init {
        View.inflate(context, R.layout.item_ingredient, this)
        val padding = context.dimen(R.dimen.small_padding)
        setPadding(padding, padding, padding, padding)
    }

    fun render(ingredient: Ingredient) {
        nameView.text = ingredient.name.trim()
        quantityView.text = ingredient.quantity.trim()
    }

}