/*
 * By Martin Chamarro for ASOS
 * Copyright 2018 Martin Chamarro (@martinchamarro)
 */

package com.asos.recipes.presentation.ui.splash

import android.os.Bundle
import com.asos.recipes.R
import com.asos.recipes.presentation.base.BaseActivity
import com.asos.recipes.presentation.extensions.activityComponent
import com.asos.recipes.presentation.extensions.fullScreen
import javax.inject.Inject

class SplashActivity : BaseActivity(), SplashContract.View {

    @Inject lateinit var presenter: SplashContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        fullScreen()
        super.onCreate(savedInstanceState)
        activityComponent.inject(this)
        setContentView(R.layout.activity_splash)
        initializePresenter()
    }

    private fun initializePresenter() {
        presenter.view = this
        presenter.initialize()
    }

    override fun onResume() {
        super.onResume()
        presenter.onResume()
    }

    override fun onPause() {
        presenter.onPause()
        super.onPause()
    }

    override fun onDestroy() {
        presenter.onDestroy()
        super.onDestroy()
    }

}