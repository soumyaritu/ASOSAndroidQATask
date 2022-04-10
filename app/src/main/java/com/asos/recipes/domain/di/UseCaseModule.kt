/*
 * By Martin Chamarro for ASOS
 * Copyright 2018 Martin Chamarro (@martinchamarro)
 */

package com.asos.recipes.domain.di

import com.asos.recipes.domain.repository.Repository
import com.asos.recipes.domain.usecase.GetRecipeByName
import com.asos.recipes.domain.usecase.GetRecipes
import com.asos.recipes.threading.Executor
import com.asos.recipes.threading.MainThread
import dagger.Module
import dagger.Provides

@Module
class UseCaseModule {

    @Provides fun providesGetRecipes(executor: Executor, mainThread: MainThread, repository: Repository): GetRecipes {
        return GetRecipes(executor, mainThread, repository)
    }

    @Provides fun providesGetRecipeByName(executor: Executor, mainThread: MainThread, repository: Repository): GetRecipeByName {
        return GetRecipeByName(executor, mainThread, repository)
    }

}