package com.atul.fampay.contextualcards

import android.app.Application
import android.content.Context
import androidx.appcompat.app.AppCompatDelegate

/**
 * Application class to get [Context] Application Instances all over the application codebase
 */

class MyApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        instance = this
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true)
    }

    companion object {
        lateinit var instance: MyApplication
        fun getContext(): Context = instance.applicationContext
    }
}