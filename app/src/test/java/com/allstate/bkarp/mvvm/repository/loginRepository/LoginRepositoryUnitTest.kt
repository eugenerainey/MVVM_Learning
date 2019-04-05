package com.allstate.bkarp.mvvm.repository.loginRepository

import io.reactivex.android.plugins.RxAndroidPlugins
import io.reactivex.observers.TestObserver
import io.reactivex.plugins.RxJavaPlugins
import io.reactivex.schedulers.Schedulers
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.mockito.MockitoAnnotations

class LoginRepositoryUnitTest {

    private var loginRepository = LoginRepository()

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)

        RxJavaPlugins.setInitIoSchedulerHandler { Schedulers.trampoline() }
        RxAndroidPlugins.setInitMainThreadSchedulerHandler { Schedulers.trampoline() }
    }

    @After
    fun tearDown() {
        RxJavaPlugins.reset()
        RxAndroidPlugins.reset()
    }

    @Test
    fun testLoginSuccess() {
//        Arrange
        val testObserver = TestObserver<Boolean>()
//        Act
        loginRepository.loginUser("username", "password")
            .subscribe(testObserver)
//        Assert
        testObserver.assertSubscribed()
        testObserver.assertNoErrors()
        testObserver.assertComplete()
        testObserver.assertValue(true)
    }

    @Test
    fun testLoginFailure() {
//        Arrange
        val testObserver = TestObserver<Boolean>()
//        Act
        loginRepository.loginUser("username", "pass")
            .subscribe(testObserver)
//        Assert
        testObserver.assertSubscribed()
        testObserver.assertNoErrors()
        testObserver.assertComplete()
        testObserver.assertValue(false)
    }
}