/*
 * By Martin Chamarro for ASOS
 * Copyright 2018 Martin Chamarro (@martinchamarro)
 */

package com.asos.recipes.presentation.ui.home

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.AdapterView
import android.widget.EditText
import com.asos.recipes.R
import com.asos.recipes.domain.model.Recipe
import com.asos.recipes.domain.model.DifficultyFilter
import com.asos.recipes.domain.model.PreparationTimeFilter
import com.asos.recipes.presentation.base.BaseActivity
import com.asos.recipes.presentation.extensions.*
import com.asos.recipes.presentation.ui.home.views.DifficultySpinner
import com.asos.recipes.presentation.ui.home.views.ItemOffsetDecorator
import com.asos.recipes.presentation.ui.home.views.PreparationTimeSpinner
import com.asos.recipes.presentation.ui.home.views.RecipesAdapter
import kotlinx.android.synthetic.main.activity_home.*
import javax.inject.Inject

class HomeActivity : BaseActivity(), HomeContract.View {

    companion object {
        private val TAG: String = HomeActivity::class.java.simpleName
        fun start(context: Context) {
            val intent = Intent(context, HomeActivity::class.java)
            context.startActivity(intent)
        }
    }

    @Inject
    lateinit var presenter: HomeContract.Presenter
    @Inject
    lateinit var adapter: RecipesAdapter

    override val searchText: String
        get() = searchInput.string

    override val difficultyFilter: DifficultyFilter
        get() = difficultySpinner.getSelected()

    override val preparationTimeFilter: PreparationTimeFilter
        get() = preparationTimeSpinner.getSelected()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityComponent.inject(this)
        setContentView(R.layout.activity_home)
        configureRecycler()
        setupListeners()
        initializePresenter()
    }

    private fun configureRecycler() {
        val numColumns = integer(R.integer.recipes_grid_columns)
        recipesRecycler.layoutManager = GridLayoutManager(context, numColumns)
        recipesRecycler.addItemDecoration(ItemOffsetDecorator(dimen(R.dimen.recipe_item_spacing)))
        recipesRecycler.adapter = adapter
    }

    private fun setupListeners() {
        findViewById<EditText>(R.id.searchInput).addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun afterTextChanged(s: Editable?) {}
            override fun onTextChanged(text: CharSequence?, start: Int, before: Int, count: Int) {
                if (text.isNullOrEmpty()) searchInput.hideKeyboard()
                presenter.refresh()
            }
        })
        findViewById<DifficultySpinner>(R.id.difficultySpinner).onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {}
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) { presenter.refresh() }
        }
        findViewById<PreparationTimeSpinner>(R.id.preparationTimeSpinner).onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {}
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) { presenter.refresh() }
        }
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

    override fun render(recipes: List<Recipe>) {
        adapter.onRecipeClick = presenter::onRecipeClick
        adapter.recipes = recipes
    }

    override fun showLoading() = loading.visible()

    override fun hideLoading() = loading.gone()

    override fun showEmpty() = emptyView.visible()

    override fun hideEmpty() = emptyView.gone()

    override fun onDestroy() {
        presenter.onDestroy()
        super.onDestroy()
    }

}