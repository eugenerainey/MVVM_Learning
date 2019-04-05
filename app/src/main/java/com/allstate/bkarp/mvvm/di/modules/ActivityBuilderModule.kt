package com.allstate.bkarp.mvvm.di.modules

import com.allstate.bkarp.mvvm.ui.loginScreen.LoginActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilderModule {

    @SuppressWarnings("Unused")
    @ContributesAndroidInjector()
    abstract fun contributeLoginActivityInjector(): LoginActivity
}