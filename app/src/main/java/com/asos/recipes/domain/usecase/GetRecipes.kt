/*
 * By Martin Chamarro for ASOS
 * Copyright 2018 Martin Chamarro (@martinchamarro)
 */

package com.asos.recipes.domain.usecase

import com.asos.recipes.domain.model.Recipe
import com.asos.recipes.domain.repository.Repository
import com.asos.recipes.threading.Executor
import com.asos.recipes.threading.MainThread
import io.reactivex.rxjava3.core.Observable
import javax.inject.Inject

class GetRecipes @Inject constructor(
        executor: Executor,
        mainThread: MainThread,
        private val repository: Repository) : UseCase<List<Recipe>>(executor, mainThread) {

    lateinit var params: GetRecipesParams

    override fun buildObservable(): Observable<List<Recipe>> = repository.getRecipes(params)

}