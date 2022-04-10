/*
 * By Martin Chamarro for ASOS
 * Copyright 2018 Martin Chamarro (@martinchamarro)
 */

package com.asos.recipes.globalutils.extensions

import java.util.Collections

fun <T> Collection<T>?.isNullOrEmpty(): Boolean = this == null || this.isEmpty()

fun <T> Collection<T>?.isNotNullOrEmpty(): Boolean = !this.isNullOrEmpty()

fun <T> List<T>.shuffle() = Collections.shuffle(this)

fun <T> List<T>?.isNullOrEmpty(): Boolean = this == null || this.isEmpty()

fun <T> List<T>?.isNotNullOrEmpty(): Boolean = !isNullOrEmpty()