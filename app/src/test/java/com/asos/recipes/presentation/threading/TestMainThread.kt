/*
 * By Martin Chamarro for ASOS
 * Copyright 2018 Martin Chamarro (@martinchamarro)
 */

package com.asos.recipes.presentation.threading

import com.asos.recipes.threading.MainThread
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.schedulers.TestScheduler

/**
 * Uses the test scheduler of RxJava 2
 */
class TestMainThread(private val testScheduler: TestScheduler) : MainThread {
    override fun getScheduler(): Scheduler = testScheduler
}