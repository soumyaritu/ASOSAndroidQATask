/*
 * By Martin Chamarro for ASOS
 * Copyright 2018 Martin Chamarro (@martinchamarro)
 */

package com.asos.recipes.threading

import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.schedulers.Schedulers
import java.util.concurrent.LinkedBlockingQueue
import java.util.concurrent.ThreadPoolExecutor
import java.util.concurrent.TimeUnit

import javax.inject.Inject
import javax.inject.Singleton

/**
 * Executor of use cases implemented using a ThreadPoolExecutor
 */
@Singleton class ThreadPoolExecutor @Inject constructor() : Executor {

    companion object {
        private val CORE_POOL_SIZE = 3
        private val MAX_POOL_SIZE = 5
        private val KEEP_ALIVE_TIME = 60L
        private val TIME_UNIT = TimeUnit.SECONDS
        private val WORK_QUEUE = LinkedBlockingQueue<Runnable>()
    }

    private val threadExecutor: ThreadPoolExecutor

    init {
        threadExecutor = ThreadPoolExecutor(CORE_POOL_SIZE, MAX_POOL_SIZE, KEEP_ALIVE_TIME, TIME_UNIT, WORK_QUEUE)
    }

    override fun getScheduler(): Scheduler = Schedulers.from(threadExecutor)

}