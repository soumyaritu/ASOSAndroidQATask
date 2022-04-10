/*
 * By Martin Chamarro for ASOS
 * Copyright 2018 Martin Chamarro (@martinchamarro)
 */

package com.asos.recipes.threading.di

import com.asos.recipes.threading.*
import javax.inject.Singleton

import dagger.Module
import dagger.Provides

@Module class ThreadingModule {

    @Provides @Singleton fun provideExecutor(executor: ThreadPoolExecutor): Executor = executor

    @Provides @Singleton fun provideMainThread(thread: UIThread): MainThread = thread

}