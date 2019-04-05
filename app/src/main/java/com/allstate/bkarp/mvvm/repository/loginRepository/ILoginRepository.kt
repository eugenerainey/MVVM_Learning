package com.allstate.bkarp.mvvm.repository.loginRepository

import com.allstate.bkarp.mvvm.objects.TestObject
import io.reactivex.Single

interface ILoginRepository {

    fun loginUser(username: String, password: String): Single<Boolean>

    fun getTestObject(): Single<TestObject>
}