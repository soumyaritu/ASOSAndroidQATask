/*
 * By Martin Chamarro for ASOS
 * Copyright 2018 Martin Chamarro (@martinchamarro)
 */

package com.asos.recipes.domain.usecase

import com.asos.recipes.domain.model.DifficultyFilter
import com.asos.recipes.domain.model.PreparationTimeFilter

class GetRecipesParams(
        val searchText: String = "",
        val difficultyFilter: DifficultyFilter = DifficultyFilter.All,
        val preparationTimeFilter: PreparationTimeFilter = PreparationTimeFilter.All)