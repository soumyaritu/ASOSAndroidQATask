/*
 * By Martin Chamarro for ASOS
 * Copyright 2018 Martin Chamarro (@martinchamarro)
 */

package com.asos.recipes.data.api

import com.asos.recipes.data.entity.RecipeEntity
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers

interface Services {

    companion object {
        const val HEADER_CACHE_ONE_HOUR = "Cache-Control: public, max-age=3600"
    }

    @GET("/sampleapifortest/recipes.json")
    @Headers(HEADER_CACHE_ONE_HOUR)
    fun getRecipes(): Call<List<RecipeEntity>>

}
