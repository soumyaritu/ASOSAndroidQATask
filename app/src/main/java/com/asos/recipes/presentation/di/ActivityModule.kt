/*
 * By Martin Chamarro for ASOS
 * Copyright 2018 Martin Chamarro (@martinchamarro)
 */

package com.asos.recipes.presentation.di

import android.app.Activity
import com.asos.recipes.presentation.navigation.Navigator

import dagger.Module
import dagger.Provides

@Module class ActivityModule(private val activity: Activity) {

    @Provides @PerActivity internal fun provideActivity(): Activity = activity

    @Provides @PerActivity fun provideNavigator(activity: Activity) = Navigator(activity)

}
