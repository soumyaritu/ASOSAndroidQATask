/*
 * By Martin Chamarro for ASOS
 * Copyright 2018 Martin Chamarro (@martinchamarro)
 */

package com.asos.recipes.presentation.ui.detail.views

import android.view.View
import com.asos.recipes.R
import com.asos.recipes.domain.model.Recipe
import com.asos.recipes.presentation.extensions.load
import com.asos.recipes.presentation.extensions.string
import kotlinx.android.synthetic.main.activity_detail.view.*
import javax.inject.Inject

class DetailRenderer @Inject constructor() {

    fun render(view: View, recipe: Recipe) = with(view) {
        toolbar.title = recipe.name
        pictureView.load(recipe.imageUrl, R.drawable.ic_default_picture)
        titleView.text = recipe.name
        renderIngredients(view, recipe)
        renderInstructions(view, recipe)
    }

    private fun renderIngredients(view: View, recipe: Recipe) = with(view) {
        ingredientsLabel.text = string(R.string.detail_ingredients).format(recipe.ingredients.size)
        recipe.ingredients.map { IngredientView(context, it) }
                .forEach { ingredientsWrapper.addView(it) }
    }

    private fun renderInstructions(view: View, recipe: Recipe) = with(view) {
        recipe.steps.mapIndexed { pos, step -> InstructionView(view.context).apply { render(pos, step) } }
                .forEach { instructionsWrapper.addView(it) }
    }

}