package com.allstate.bkarp.mvvm

import com.allstate.bkarp.mvvm.di.DaggerApplicationComponent
import dagger.android.AndroidInjector
import dagger.android.HasActivityInjector
import dagger.android.support.DaggerApplication

class MVVMApplication: DaggerApplication(), HasActivityInjector {

    override fun onCreate() {
        super.onCreate()
    }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerApplicationComponent.builder()
            .application(this)
            .build()
    }
}