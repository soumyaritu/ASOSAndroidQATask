package com.asos.recipes.presentation.ui

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.intent.rule.IntentsTestRule
import android.support.test.espresso.matcher.ViewMatchers.isDisplayed
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.support.test.runner.AndroidJUnit4
import com.asos.recipes.R
import com.asos.recipes.presentation.ui.home.HomeActivity
import org.hamcrest.Matchers.not
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

private const val RECIPES_LOAD_DELAY = 3000L

@RunWith(AndroidJUnit4::class)
class HomeActivityTest {

    @get:Rule
    var rule = IntentsTestRule(HomeActivity::class.java)

    @Before
    fun setUp() {
        rule.applicationComponent.cache().invalidate()
    }

    @Test
    fun displaysRecipeListPage() {
        // Waits until the recipes list content is loaded
        delay(RECIPES_LOAD_DELAY)
        // Checks that the loading layout is hidden and the recipe list is displayed
        onView(withId(R.id.loading)).check(matches(not(isDisplayed())))
        onView(withId(R.id.recipesRecycler)).check(matches(isDisplayed()))
    }
}