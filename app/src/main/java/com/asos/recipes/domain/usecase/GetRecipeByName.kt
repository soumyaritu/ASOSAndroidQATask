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
import kotlin.properties.Delegates

class GetRecipeByName @Inject constructor(
        executor: Executor,
        mainThread: MainThread,
        private val repository: Repository) : UseCase<Recipe>(executor, mainThread) {

    var name by Delegates.notNull<String>()

    override fun buildObservable(): Observable<Recipe> = repository.getRecipeByName(name)
}