package com.allstate.bkarp.mvvm.di.modules

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import com.allstate.bkarp.mvvm.BuildConfig
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(includes = [ViewModelModule::class, RepositoryModule::class])
class ApplicationModule {

    @Singleton
    @Provides
    fun provideContext(application: Application): Context {
        return application
    }

    @Singleton
    @Provides
    fun provideSharedPrefs(application: Application): SharedPreferences {
        return application.getSharedPreferences(BuildConfig.APPLICATION_ID, Context.MODE_PRIVATE)
    }
}