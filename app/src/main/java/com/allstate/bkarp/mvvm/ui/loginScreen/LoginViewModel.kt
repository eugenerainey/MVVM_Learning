package com.allstate.bkarp.mvvm.ui.loginScreen

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.text.SpannableString
import com.allstate.bkarp.mvvm.objects.TestObject
import com.allstate.bkarp.mvvm.repository.loginRepository.ILoginRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class LoginViewModel @Inject constructor(var loginRepository: ILoginRepository) : ViewModel() {


    val isLoginSucessfulLiveData = MutableLiveData<Boolean>()

    val testLiveData = MutableLiveData<Int>()
    val testLiveDataArray = MutableLiveData<ArrayList<String>>()

    val testObjectLiveData = MutableLiveData<TestObject>()

    fun loginUser(username: String?, password: String?) {
        if (!username.isNullOrEmpty() && !password.isNullOrEmpty()) {
            loginRepository.loginUser(username!!, password!!)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe {
                     result -> handleSuccess(result)
                }
        }
    }

    fun getTestObject(){
        loginRepository.getTestObject()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(){
                myResult -> handleObject(myResult)
            }
    }

    private fun handleObject(myResult: TestObject?) {
        testObjectLiveData.postValue(myResult)
    }

    private fun handleSuccess(result: Boolean) {
        isLoginSucessfulLiveData.postValue(result)
        testLiveData.postValue(1)


    }

    private fun handleError() {

    }
}