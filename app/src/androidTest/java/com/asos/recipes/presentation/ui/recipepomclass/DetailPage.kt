package com.asos.recipes.presentation.ui.recipepomclass

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.ViewInteraction
import android.support.test.espresso.matcher.ViewMatchers.withId
import com.asos.recipes.R
import com.asos.recipes.presentation.ui.espressobaseclass.EspressoBaseClass

class DetailPage: EspressoBaseClass() {
    companion object{
        var recipeTitle: ViewInteraction = onView(withId(R.id.titleView))
        var ingredientLabel:ViewInteraction= onView(withId(R.id.ingredientsLabel))
        var instructionsLabel:ViewInteraction= onView(withId(R.id.instructionsLabel))
        var backButton:ViewInteraction= onView(withId(R.id.toolbar))

    }
}