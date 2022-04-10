/*
 * By Martin Chamarro for ASOS
 * Copyright 2018 Martin Chamarro (@martinchamarro)
 */

package com.asos.recipes.domain.usecase

import com.asos.recipes.threading.Executor
import com.asos.recipes.threading.MainThread
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Observer

abstract class UseCase<OUTPUT>(
        private val executor: Executor,
        private val mainThread: MainThread) {

    fun execute(observer: Observer<OUTPUT>) {
        buildObservable()
                .subscribeOn(executor.getScheduler())
                .observeOn(mainThread.getScheduler())
                .subscribe(observer)
    }

    abstract fun buildObservable(): Observable<OUTPUT>

}