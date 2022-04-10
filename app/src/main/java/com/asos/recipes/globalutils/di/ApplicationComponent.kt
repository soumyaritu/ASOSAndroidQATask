/*
 * By Martin Chamarro for ASOS
 * Copyright 2018 Martin Chamarro (@martinchamarro)
 */

package com.asos.recipes.globalutils.di

import android.content.Context
import com.asos.recipes.data.cache.Cache
import com.asos.recipes.data.di.DataModule
import com.asos.recipes.domain.repository.Repository
import com.asos.recipes.globalutils.logger.Logger
import com.asos.recipes.threading.Executor
import com.asos.recipes.threading.MainThread
import com.asos.recipes.threading.di.ThreadingModule

import javax.inject.Singleton

import dagger.Component

@Singleton
@Component(modules = [ApplicationModule::class, DataModule::class, ThreadingModule::class])
interface ApplicationComponent {

    fun context(): Context
    fun logger(): Logger
    fun executor(): Executor
    fun mainThread(): MainThread
    fun repository(): Repository
    fun cache(): Cache

}
