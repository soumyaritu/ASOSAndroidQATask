/*
 * By Martin Chamarro for ASOS
 * Copyright 2018 Martin Chamarro (@martinchamarro)
 */

package com.asos.recipes.presentation.threading

import com.asos.recipes.threading.Executor
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.schedulers.TestScheduler

/**
 * Uses the test scheduler of RxJava 2
 */
class TestExecutor(private val testScheduler: TestScheduler) : Executor {
    override fun getScheduler(): Scheduler = testScheduler
}