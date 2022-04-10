/*
 * By Martin Chamarro for ASOS
 * Copyright 2018 Martin Chamarro (@martinchamarro)
 */

package com.asos.recipes.presentation.ui.home.views

import android.support.v7.widget.RecyclerView
import android.view.View
import com.asos.recipes.R
import com.asos.recipes.domain.model.Recipe
import com.asos.recipes.presentation.extensions.load
import com.asos.recipes.presentation.extensions.string
import kotlinx.android.synthetic.main.item_recipe.view.*

class RecipeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(recipe: Recipe) = with(itemView) {
        pictureView.load(recipe.imageUrl, R.drawable.ic_default_picture)
        titleView.text = recipe.name
        val ingredientsText = string(R.string.recipe_item_ingredients)
        ingredientsView.text = ingredientsText.format(recipe.ingredients.size)
        val minutesText = string(R.string.recipe_item_minutes)
        minutesView.text = minutesText.format(recipe.totalMinutes)
    }

}