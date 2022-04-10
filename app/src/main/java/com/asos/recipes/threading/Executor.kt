/*
 * By Martin Chamarro for ASOS
 * Copyright 2018 Martin Chamarro (@martinchamarro)
 */

package com.asos.recipes.threading

import io.reactivex.rxjava3.core.Scheduler

interface Executor {
    fun getScheduler(): Scheduler
}