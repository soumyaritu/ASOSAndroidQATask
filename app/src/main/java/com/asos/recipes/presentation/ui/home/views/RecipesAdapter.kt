/*
 * By Martin Chamarro for ASOS
 * Copyright 2018 Martin Chamarro (@martinchamarro)
 */

package com.asos.recipes.presentation.ui.home.views

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.asos.recipes.R
import com.asos.recipes.domain.model.Recipe
import com.asos.recipes.presentation.extensions.layout
import javax.inject.Inject

class RecipesAdapter @Inject constructor(
        private val context: Context): RecyclerView.Adapter<RecipeViewHolder>() {

    var recipes: List<Recipe> = listOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    var onRecipeClick: (Recipe) -> Unit = {}

    override fun getItemCount(): Int = recipes.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeViewHolder {
        return RecipeViewHolder(context.layout(R.layout.item_recipe))
    }

    override fun onBindViewHolder(holder: RecipeViewHolder, position: Int) {
        holder.run {
            val recipe = recipes[position]
            bind(recipe)
            itemView.setOnClickListener { onRecipeClick(recipe) }
        }
    }

}