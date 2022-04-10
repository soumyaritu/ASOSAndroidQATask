/*
 * By Martin Chamarro for ASOS
 * Copyright 2018 Martin Chamarro (@martinchamarro)
 */

package com.asos.recipes.data.repository

import com.asos.recipes.data.api.Api
import com.asos.recipes.data.cache.Cache
import com.asos.recipes.data.entity.RecipeEntity
import com.asos.recipes.data.mapper.RecipeEntityMapper
import com.asos.recipes.domain.exception.RepositoryException
import com.asos.recipes.domain.model.Recipe
import com.asos.recipes.domain.repository.Repository
import com.asos.recipes.domain.usecase.GetRecipesParams
import com.asos.recipes.globalutils.extensions.isNullOrEmpty
import com.asos.recipes.globalutils.logger.Logger
import io.reactivex.rxjava3.core.Observable
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RepositoryImpl @Inject constructor(
        private val api: Api,
        private val cache: Cache,
        private val recipeMapper: RecipeEntityMapper,
        private val logger: Logger) : Repository {

    companion object {
        private val TAG: String = RepositoryImpl::class.java.simpleName
    }

    override fun getRecipes(params: GetRecipesParams): Observable<List<Recipe>> {
        return Observable.create { emitter ->
            val entities = getEntities()
            if (entities.isNullOrEmpty()) {
                emitter.onError(RepositoryException.RecipeNotFoundException())
                logger.e(TAG, "Error loading recipes. The list is null or empty.")
            }
            val recipes = entities.map { recipeMapper(it) }
            val filteredRecipes = filterRecipes(recipes, params)
            emitter.onNext(filteredRecipes)
            emitter.onComplete()
        }
    }

    private fun getEntities(): List<RecipeEntity> {
        return when {
            cache.isEmpty() -> api.getRecipes().apply { cache.putAll(this) }
            else -> cache.getAll()
        }
    }

    private fun filterRecipes(recipes: List<Recipe>, params: GetRecipesParams): List<Recipe> {
        return recipes
                .filter { it.contains(params.searchText) }
                .filter { params.difficultyFilter(it) }
                .filter { params.preparationTimeFilter(it) }
    }

    override fun getRecipeByName(name: String): Observable<Recipe> {
        return Observable.create { emitter ->
            val entity = cache.get(name)
            if (entity != null) {
                emitter.onNext(recipeMapper(entity))
                emitter.onComplete()
            } else {
                logger.e(TAG, "Error getting recipe by name.")
                emitter.onError(RepositoryException.RecipeNotFoundException())
            }
        }
    }

}