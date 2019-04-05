package com.allstate.bkarp.mvvm.di.modules

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.allstate.bkarp.mvvm.di.factory.ViewModelFactory
import com.allstate.bkarp.mvvm.di.factory.ViewModelKey
import com.allstate.bkarp.mvvm.ui.loginScreen.LoginViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(LoginViewModel::class)
    abstract fun bindLoginViewModel(viewModel: LoginViewModel): ViewModel

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}