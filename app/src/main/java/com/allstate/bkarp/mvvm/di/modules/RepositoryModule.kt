package com.allstate.bkarp.mvvm.di.modules

import com.allstate.bkarp.mvvm.repository.loginRepository.ILoginRepository
import com.allstate.bkarp.mvvm.repository.loginRepository.LoginRepository
import com.allstate.bkarp.mvvm.repository.userRepository.IUserRepository
import com.allstate.bkarp.mvvm.repository.userRepository.UserRepository
import dagger.Binds
import dagger.Module

@Module
abstract class RepositoryModule {

    @Binds
    abstract fun bindLoginRepistory(repository: LoginRepository): ILoginRepository

    @Binds
    abstract fun bindUserRepistory(repository: UserRepository): IUserRepository
}