/*
 * By Martin Chamarro for ASOS
 * Copyright 2018 Martin Chamarro (@martinchamarro)
 */

package com.asos.recipes.presentation.di

import android.app.Activity
import com.asos.recipes.domain.di.UseCaseModule
import com.asos.recipes.globalutils.di.ApplicationComponent
import com.asos.recipes.presentation.ui.detail.DetailActivity
import com.asos.recipes.presentation.ui.home.HomeActivity
import com.asos.recipes.presentation.ui.splash.SplashActivity

import dagger.Component

@PerActivity
@Component(
        dependencies = [ApplicationComponent::class],
        modules = [ActivityModule::class, PresenterModule::class, UseCaseModule::class])
interface ActivityComponent {

    fun activity(): Activity

    fun inject(activity: DetailActivity)
    fun inject(activity: HomeActivity)
    fun inject(activity: SplashActivity)

}
