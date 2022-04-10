/*
 * By Martin Chamarro for ASOS
 * Copyright 2018 Martin Chamarro (@martinchamarro)
 */

package com.asos.recipes.presentation.ui.detail

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.asos.recipes.R
import com.asos.recipes.domain.model.Recipe
import com.asos.recipes.presentation.base.BaseActivity
import com.asos.recipes.presentation.extensions.activityComponent
import com.asos.recipes.presentation.extensions.fullScreen
import com.asos.recipes.presentation.extensions.gone
import com.asos.recipes.presentation.extensions.visible
import com.asos.recipes.presentation.ui.detail.views.DetailRenderer
import kotlinx.android.synthetic.main.activity_detail.*
import javax.inject.Inject

class DetailActivity : BaseActivity(), DetailContract.View {

    companion object {
        private val TAG: String = DetailActivity::class.java.simpleName
        const val EXTRA_RECIPE_NAME = "recipe_name"
        fun start(context: Context, recipeName: String) {
            val intent = Intent(context, DetailActivity::class.java).apply {
                putExtra(EXTRA_RECIPE_NAME, recipeName)
            }
            context.startActivity(intent)
        }
    }

    @Inject lateinit var presenter: DetailContract.Presenter
    @Inject lateinit var renderer: DetailRenderer
    override val recipeName: String get() = intent.getStringExtra(EXTRA_RECIPE_NAME)!!

    override fun onCreate(savedInstanceState: Bundle?) {
        fullScreen()
        super.onCreate(savedInstanceState)
        activityComponent.inject(this)
        setContentView(R.layout.activity_detail)
        configureToolbar()
        initializePresenter()
    }

    private fun configureToolbar() {
        toolbar.setNavigationOnClickListener { finish() }
        // FIX: there's a bug that cuts the appbar title
        // https://stackoverflow.com/a/43676163/2271287
        // https://issuetracker.google.com/issues/37140811
        collapsingToolbar.post { collapsingToolbar.requestLayout() }
    }

    private fun initializePresenter() {
        presenter.view = this
        presenter.initialize()
    }

    override fun render(recipe: Recipe) = renderer.render(rootView, recipe)

    override fun showLoading() = progress.visible()

    override fun hideLoading() = progress.gone()
}