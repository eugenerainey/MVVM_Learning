package com.allstate.bkarp.mvvm.ui.loginScreen

import android.app.PendingIntent.getActivity
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.widget.Toast
import com.allstate.bkarp.mvvm.R
import com.allstate.bkarp.mvvm.di.tempViewModel
import com.allstate.bkarp.mvvm.objects.TestObject
import com.allstate.bkarp.mvvm.ui.common.BaseActivity
import kotlinx.android.synthetic.main.activity_login.*

import javax.inject.Inject

class LoginActivity: BaseActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var viewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        //Why use a Factory instead of just getting a ViewModel instance straight from the ViewModel class
        viewModel = ViewModelProviders.of(this, viewModelFactory)[LoginViewModel::class.java]
       // viewModel = ViewModelProviders.of(this).get(LoginViewModel::class.java)

        btnLogin.setOnClickListener { _ -> loginUser() }
        btnGetObject.setOnClickListener { _ -> getObject() }

        viewModel.isLoginSucessfulLiveData.observe(this, Observer {
                isSuccessful -> handleLogin(isSuccessful)
        })

        viewModel.testLiveData.observe(this, Observer {
                bla -> Toast.makeText(this, bla.toString(), Toast.LENGTH_LONG).show()})

        viewModel.testObjectLiveData.observe(this, Observer {
            resultObject -> displayObject(resultObject)
        })

    }

    private fun loginUser() {
        viewModel.loginUser(etLoginUsername.text.toString(), etLoginPassword.text.toString())
    }

    private fun getObject(){
        viewModel.getTestObject()
    }

    private fun handleLogin(isSucessful: Boolean?) {
        if (isSucessful != null){
            Toast.makeText(this, isSucessful.toString(), Toast.LENGTH_LONG).show()
        }
    }

    private fun displayObject(testObject: TestObject?){
        if(testObject != null){
            Toast.makeText(this, testObject.property1 + testObject.property2.toString() + testObject.property3.toString(), Toast.LENGTH_LONG).show()
        }
    }

}