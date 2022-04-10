/*
 * By Martin Chamarro for ASOS
 * Copyright 2018 Martin Chamarro (@martinchamarro)
 */

package com.asos.recipes.presentation.di

import javax.inject.Scope

/**
 * A scoping annotation to permit objects whose lifetime should
 * conform to the life of the activity to be memoized in the
 * correct component.
 */
@Scope
@kotlin.annotation.Retention
annotation class PerActivity
