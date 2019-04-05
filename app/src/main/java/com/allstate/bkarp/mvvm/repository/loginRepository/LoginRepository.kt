package com.allstate.bkarp.mvvm.repository.loginRepository

import com.allstate.bkarp.mvvm.objects.TestObject
import io.reactivex.Single
import javax.inject.Inject

class LoginRepository @Inject constructor() : ILoginRepository {
    override fun loginUser(username: String, password: String): Single<Boolean> {
        return if (username == "username" && password == "password") {
            Single.just(true)
        } else {
            Single.just(false)
        }
    }

    override fun getTestObject(): Single<TestObject> {
        val testObject =  TestObject()

        testObject.property1 = "property1"
        testObject.property2 = 100
        testObject.property3 = true

        return  Single.just(testObject)

    }
}