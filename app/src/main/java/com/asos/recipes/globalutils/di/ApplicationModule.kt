/*
 * By Martin Chamarro for ASOS
 * Copyright 2018 Martin Chamarro (@martinchamarro)
 */

package com.asos.recipes.globalutils.di

import android.app.Application
import android.content.Context
import com.asos.recipes.globalutils.logger.Logger

import javax.inject.Singleton

import dagger.Module
import dagger.Provides

@Module class ApplicationModule(private val application: Application) {

    @Provides @Singleton internal fun provideApplicationContext(): Context = application

    @Provides @Singleton fun provideLogger() = Logger

}
