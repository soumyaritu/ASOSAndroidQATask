/*
 * By Martin Chamarro for ASOS
 * Copyright 2018 Martin Chamarro (@martinchamarro)
 */

package com.asos.recipes.data.api

import com.asos.recipes.data.entity.RecipeEntity
import retrofit2.Call
import javax.inject.Inject

class RetrofitApi @Inject constructor(servicesFactory: RetrofitServicesFactory) : Api {

    private val services = servicesFactory.create()

    override fun getRecipes(): List<RecipeEntity> = execute(services.getRecipes())

    private fun <T> execute(call: Call<T>) = call.execute().body()!!
}
