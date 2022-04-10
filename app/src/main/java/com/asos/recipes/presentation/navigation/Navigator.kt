/*
 * By Martin Chamarro for ASOS
 * Copyright 2018 Martin Chamarro (@martinchamarro)
 */

package com.asos.recipes.presentation.navigation

import android.app.Activity
import com.asos.recipes.presentation.di.PerActivity
import com.asos.recipes.presentation.ui.detail.DetailActivity
import com.asos.recipes.presentation.ui.home.HomeActivity
import javax.inject.Inject

@PerActivity
class Navigator @Inject constructor(private val activity: Activity) {

    fun navigateToHome() = HomeActivity.start(activity)

    fun navigateToDetail(recipeName: String) = DetailActivity.start(activity, recipeName)

}