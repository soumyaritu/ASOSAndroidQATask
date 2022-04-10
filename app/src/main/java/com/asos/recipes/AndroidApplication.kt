/*
 * By Martin Chamarro for ASOS
 * Copyright 2018 Martin Chamarro (@martinchamarro)
 */

package com.asos.recipes

import android.app.Application
import com.asos.recipes.globalutils.di.ApplicationComponent
import com.asos.recipes.globalutils.di.ApplicationModule
import com.asos.recipes.globalutils.di.DaggerApplicationComponent

class AndroidApplication : Application() {

    lateinit var applicationComponent: ApplicationComponent
        private set

    override fun onCreate() {
        super.onCreate()
        initializeInjection()
    }

    private fun initializeInjection() {
        applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(ApplicationModule(this))
                .build()
    }

}