/*
 * By Martin Chamarro for ASOS
 * Copyright 2018 Martin Chamarro (@martinchamarro)
 */

package com.asos.recipes.presentation.di

import com.asos.recipes.presentation.ui.detail.DetailContract
import com.asos.recipes.presentation.ui.detail.DetailPresenter
import com.asos.recipes.presentation.ui.home.HomeContract
import com.asos.recipes.presentation.ui.home.HomePresenter
import com.asos.recipes.presentation.ui.splash.SplashContract
import com.asos.recipes.presentation.ui.splash.SplashPresenter
import dagger.Module
import dagger.Provides

@Module
class PresenterModule {

    @Provides
    fun providesSplashPresenter(presenter: SplashPresenter): SplashContract.Presenter = presenter

    @Provides
    fun providesHomePresenter(presenter: HomePresenter): HomeContract.Presenter = presenter

    @Provides
    fun providesDetailPresenter(presenter: DetailPresenter): DetailContract.Presenter = presenter

}
