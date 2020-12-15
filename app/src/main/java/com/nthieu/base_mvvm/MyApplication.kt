package com.nthieu.base_mvvm

import android.app.Application
import com.nthieu.base_mvvm.di.compoment.DaggerAppComponent

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        DaggerAppComponent
            .builder()
            .application(this)
            ?.build()
            ?.inject(this)
    }
}