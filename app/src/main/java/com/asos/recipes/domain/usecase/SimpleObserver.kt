/*
 * By Martin Chamarro for ASOS
 * Copyright 2018 Martin Chamarro (@martinchamarro)
 */

package com.asos.recipes.domain.usecase

import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable

class SimpleObserver<T> constructor(
    val onSubscribe: (Disposable) -> Unit = {},
    val onNext: (T) -> Unit = {},
    val onError: (Throwable) -> Unit = {},
    val onComplete: () -> Unit = {}) : Observer<T> {

    override fun onSubscribe(d: Disposable) = onSubscribe.invoke(d)

    override fun onNext(t: T) = onNext.invoke(t)

    override fun onError(e: Throwable) = onError.invoke(e)

    override fun onComplete() = onComplete.invoke()

}