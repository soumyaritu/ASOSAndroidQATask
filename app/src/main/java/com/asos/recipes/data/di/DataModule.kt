/*
 * By Martin Chamarro for ASOS
 * Copyright 2018 Martin Chamarro (@martinchamarro)
 */

package com.asos.recipes.data.di

import com.asos.recipes.data.api.Api
import com.asos.recipes.data.api.RetrofitApi
import com.asos.recipes.data.cache.Cache
import com.asos.recipes.data.cache.CacheImpl
import com.asos.recipes.data.repository.RepositoryImpl
import com.asos.recipes.domain.repository.Repository

import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module class DataModule {

    @Provides @Singleton fun providesRepository(repository: RepositoryImpl): Repository = repository

    @Provides @Singleton fun providesApi(api: RetrofitApi): Api = api

    @Provides @Singleton fun providesCache(cache: CacheImpl): Cache = cache

}
