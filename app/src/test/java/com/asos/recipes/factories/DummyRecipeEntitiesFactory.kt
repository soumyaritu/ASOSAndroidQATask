/*
 * By Martin Chamarro for ASOS
 * Copyright 2018 Martin Chamarro (@martinchamarro)
 */

package com.asos.recipes.factories

import com.asos.recipes.data.entity.IngredientEntity
import com.asos.recipes.data.entity.RecipeEntity

object DummyRecipeEntitiesFactory {

    fun givenAListOfRecipeEntities(): List<RecipeEntity> {
        return listOf(
                RecipeEntity(name="Crock Pot Roast", imageUrl="http://img.sndimg.com/food/image/upload/w_266/v1/img/recipes/27/20/8/picVfzLZo.jpg", originalUrl="http://www.food.com/recipe/to-die-for-crock-pot-roast-27208", steps=listOf("Place beef roast in crock pot.", "Mix the dried mixes together in a bowl and sprinkle over the roast.", "Pour the water around the roast.", "Cook on low for 7-9 hours."), timers= listOf(0, 0, 0, 420), ingredients= listOf(IngredientEntity(name = " beef roast", type = "Meat", quantity = "1"), IngredientEntity(name="brown gravy mix", type="Baking", quantity="1 package"))),
                RecipeEntity(name="Roasted Asparagus", imageUrl="http://img.sndimg.com/food/image/upload/w_266/v1/img/recipes/50/84/7/picMcSyVd.jpg", originalUrl="http://www.food.com/recipe/roasted-asparagus-50847", steps=listOf("Preheat oven to 425°F.", "Cut off the woody bottom part of the asparagus spears and discard.", "With a vegetable peeler", "peel off the skin on the bottom 2-3 inches of the spears (this keeps the asparagus from being all and if you eat asparagus you know what I mean by that).", "Place asparagus on foil-lined baking sheet and drizzle with olive oil.", "Sprinkle with salt.", "With your hands, roll the asparagus around until they are evenly coated with oil and salt."), timers= listOf(0, 0, 0, 420), ingredients= listOf(IngredientEntity(name = " beef roast", type = "Meat", quantity = "1"), IngredientEntity(name="brown gravy mix", type="Baking", quantity="1 package"))),
                RecipeEntity(name="Curried Lentils and Rice", imageUrl="http://dagzhsfg97k4.cloudfront.net/wp-content/uploads/2012/05/lentils3.jpg", originalUrl="", steps=listOf("Bring broth to a low boil.", "Add curry powder and salt.", "Cook lentils for 20 minutes.", "Add rice and simmer for 20 minutes.", "Enjoy!"), timers=listOf(0, 0, 20, 20, 0), ingredients=listOf(IngredientEntity(name="beef broth", type="Misc", quantity="1 quart"), IngredientEntity(name="dried green lentils", type="Misc", quantity="1 cup"), IngredientEntity(name="basmati rice", type="Misc", quantity="1/2 cup")))
        )
    }

    fun givenARecipeEntity(): RecipeEntity = givenAListOfRecipeEntities().first()

}