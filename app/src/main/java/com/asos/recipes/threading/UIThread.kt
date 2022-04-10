/*
 * By Martin Chamarro for ASOS
 * Copyright 2018 Martin Chamarro (@martinchamarro)
 */

package com.asos.recipes.threading

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Scheduler
import javax.inject.Inject
import javax.inject.Singleton

@Singleton class UIThread @Inject constructor(): MainThread {
    override fun getScheduler(): Scheduler = AndroidSchedulers.mainThread()
}