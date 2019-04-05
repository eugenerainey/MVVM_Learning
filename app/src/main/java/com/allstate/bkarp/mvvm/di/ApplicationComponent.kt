package com.allstate.bkarp.mvvm.di

import com.allstate.bkarp.mvvm.MVVMApplication
import com.allstate.bkarp.mvvm.di.modules.ActivityBuilderModule
import com.allstate.bkarp.mvvm.di.modules.ApplicationModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [AndroidSupportInjectionModule::class, ApplicationModule::class, ActivityBuilderModule::class])
interface ApplicationComponent: AndroidInjector<MVVMApplication> {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: MVVMApplication): Builder

        fun build(): ApplicationComponent
    }

    override fun inject(application: MVVMApplication)
}