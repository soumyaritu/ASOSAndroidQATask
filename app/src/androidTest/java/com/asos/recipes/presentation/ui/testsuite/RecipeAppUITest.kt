package com.asos.recipes.presentation.ui.testsuite


import android.support.test.espresso.intent.Intents
import android.support.test.espresso.intent.Intents.intended
import android.support.test.espresso.intent.matcher.IntentMatchers
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import com.asos.recipes.presentation.ui.delay
import com.asos.recipes.presentation.ui.detail.DetailActivity
import com.asos.recipes.presentation.ui.home.HomeActivity
import com.asos.recipes.presentation.ui.recipepomclass.DetailPage
import com.asos.recipes.presentation.ui.recipepomclass.HomePage
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class RecipeAppUITest {
     /* This test will handle the UI Tests of Recipe App.
       I have used POM Architecture for implementing the UI Tests because it allows us to write reusable code
       and easy to modify when necessary.
       In this project,POM class contains all ID's & elements of each page.There are two POM classes 1. Detail Page
       2. HomePage
       Espresso Base class contains all the implementation of methods of each POM class.
       RecipeAppUITest class contain all UI test cases which are automated.
    */
    private var homeActivity=HomePage()
    private var detailActivity= DetailPage()

    @get:Rule
    var mActivityTestRule = ActivityTestRule(HomeActivity::class.java)

    @Before
    fun setUp() {
        Intents.init()

    }
    @After
    fun tearDown(){
        Intents.release()

    }
    @Test
    fun verifyRecipeHomePage(){
        //Verify user should able to view the Search Text field, Filters & Recipe list in the home page
        delay(1000L)
        homeActivity.verifyHomePage()
    }
    @Test
    fun verifyIsImageClickable(){
        /* Verify that user should be able to click the Recipes in the Home Screen
        Also, User should navigates to the Recipe Details Page
         */
        homeActivity.verifyIsImageClickable()
        delay(2000L)    // Verify ,User should navigate to the Details page.
        intended(IntentMatchers.hasComponent(DetailActivity::class.java.name))
    }
    @Test
    fun verifyRecipeDetailPage(){
        /* Verify that user should be able to view the Recipe details
        * It contains Recipe Title,Ingredients  & Instruction */
        homeActivity.verifyIsImageClickable()
        delay(1000L)
        detailActivity.verifyRecipeDetailPage()
    }

    @Test
    fun verifyIsRecipeListScrollable(){
        //Verify that, user should able to scroll the Recipe list
        homeActivity.verifyIsRecipeListScrollable()
        delay(2000L)
    }
    @Test
    fun verifyDifficultyFilter(){
        /*Verify that, user should able to filter the Recipe by
        its difficulty filter such as Easy,Medium & Hard */
        homeActivity.verifyDifficultyFilter()
    }
    @Test
    fun verifyPreparationTimeFilter(){
        /*Verify that, user should able to filter the Recipe by
        Preparation time filter such as 0-30 mins,30-60 mins & 60 +mins */
        homeActivity.verifyPreparationTimeFilter()
        delay(1000L)
    }
    @Test
    fun verifyRecipeSearch(){
        /*Verify that, user should able to search the Recipe If matches found, user should view the result
        else user should show the Recipes not found screen.
         */
        homeActivity.verifyRecipeSearch()
        delay(1000L)

    }
}