package com.asos.recipes.presentation.ui.recipepomclass


import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.ViewInteraction
import android.support.test.espresso.matcher.ViewMatchers.*
import com.asos.recipes.R
import com.asos.recipes.presentation.ui.espressobaseclass.EspressoBaseClass


class HomePage : EspressoBaseClass() {
    companion object{
        var loading: ViewInteraction = onView(withId(R.id.loading))
        var recipeRecycler :ViewInteraction = onView(withId(R.id.recipesRecycler))
        var searchRecipe:ViewInteraction= onView((withId(R.id.searchInput)))
        var preparationTimeFilter:ViewInteraction= onView((withId(R.id.preparationTimeSpinner)))
        var difficultyFilter:ViewInteraction= onView(withId(R.id.difficultySpinner))
        var itemCount=9
        var preparationTime:ViewInteraction= onView(withText("30-60 mins"))
        var easyFilter:ViewInteraction= onView(withText("Easy"))
        var spinnerTextMatch="Easy"
        var recipe:ViewInteraction= onView(withText("Big Night Pizza"))
        var noResults:ViewInteraction= onView(withId(R.id.emptyTitleView))
        var noResultText="Recipes not found"

    }

}