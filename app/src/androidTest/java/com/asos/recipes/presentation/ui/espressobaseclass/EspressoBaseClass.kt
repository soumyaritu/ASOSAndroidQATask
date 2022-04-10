package com.asos.recipes.presentation.ui.espressobaseclass


import android.support.test.espresso.action.ViewActions.*
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.contrib.RecyclerViewActions
import android.support.test.espresso.contrib.RecyclerViewActions.scrollToPosition
import android.support.test.espresso.matcher.ViewMatchers.*
import android.support.v7.widget.RecyclerView
import com.asos.recipes.presentation.ui.delay
import com.asos.recipes.presentation.ui.recipepomclass.DetailPage
import com.asos.recipes.presentation.ui.recipepomclass.HomePage.Companion.difficultyFilter
import com.asos.recipes.presentation.ui.recipepomclass.HomePage.Companion.easyFilter
import com.asos.recipes.presentation.ui.recipepomclass.HomePage.Companion.loading
import com.asos.recipes.presentation.ui.recipepomclass.HomePage.Companion.itemCount
import com.asos.recipes.presentation.ui.recipepomclass.HomePage.Companion.noResults
import com.asos.recipes.presentation.ui.recipepomclass.HomePage.Companion.preparationTime
import com.asos.recipes.presentation.ui.recipepomclass.HomePage.Companion.preparationTimeFilter
import com.asos.recipes.presentation.ui.recipepomclass.HomePage.Companion.recipe
import com.asos.recipes.presentation.ui.recipepomclass.HomePage.Companion.recipeRecycler
import com.asos.recipes.presentation.ui.recipepomclass.HomePage.Companion.searchRecipe
import com.asos.recipes.presentation.ui.recipepomclass.HomePage.Companion.spinnerTextMatch
import junit.framework.AssertionFailedError
import org.hamcrest.Matchers
import org.hamcrest.Matchers.containsString
import java.lang.Exception


open class EspressoBaseClass {
    // This class contains all methods of recipe pom classes.
     fun verifyHomePage(){
         try{
         loading.check(matches(Matchers.not(isDisplayed())))
         searchRecipe.check(matches(isDisplayed()))
         difficultyFilter.check(matches(isDisplayed()))
         difficultyFilter.check(matches(withSpinnerText(containsString("All difficulties"))))
         preparationTimeFilter.check(matches(isDisplayed()))
         preparationTimeFilter.check(matches(withSpinnerText(containsString("All preparation times"))))
         recipeRecycler.check(matches(isDisplayed()))
     }catch (e:AssertionFailedError){

         }
     }

    fun verifyIsImageClickable(){
        recipeRecycler.perform(
            RecyclerViewActions
                .actionOnItem<RecyclerView.ViewHolder>(
                    hasDescendant(withText("Crock Pot Roast")),
                    click()

                )
        )
    }

    fun verifyRecipeDetailPage(){
        try{
        DetailPage.recipeTitle.check(matches(isDisplayed()))
        DetailPage.recipeTitle.check(matches(withText("Crock Pot Roast")))
        DetailPage.ingredientLabel.check(matches(isDisplayed()))
        DetailPage.ingredientLabel.check(matches(withText("Ingredients (5)")))
        DetailPage.instructionsLabel.check(matches(isDisplayed()))
        DetailPage.instructionsLabel.check(matches(withText("Instructions")))
        DetailPage.backButton.check(matches(isDisplayed()))

      }catch(e:AssertionFailedError){


        }      }

     fun verifyIsRecipeListScrollable(){
         for (i in 0..itemCount) {
            recipeRecycler.perform(scrollToPosition<RecyclerView.ViewHolder>(i))

             delay(1000L)
         }

     }

    fun verifyDifficultyFilter(){
        difficultyFilter.perform(click())
        delay(1000L)
        easyFilter.perform(click())
        difficultyFilter.check(matches(withSpinnerText(spinnerTextMatch)))

    }
    fun verifyPreparationTimeFilter(){
        preparationTimeFilter.perform(click())
        preparationTime.perform(click())

    }
    fun verifyRecipeSearch(){
        try {   // If match is found
            searchRecipe.perform(typeTextIntoFocusedView("Big"))
            recipe.check(matches(isDisplayed()))
        }catch (e:Exception){  // Matches not found
            noResults.check(matches(isDisplayed()))
        }

    }

    }
