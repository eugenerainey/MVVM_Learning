package com.allstate.bkarp.mvvm.repository.userRepository

import com.allstate.bkarp.mvvm.objects.UserInformation
import io.reactivex.Observable

class UserRepository: IUserRepository {

    private var userInformation: UserInformation? = null

    override fun getUserInformation(userId: Int): Observable<UserInformation> {
        return getUserInformationFromDB(userId).switchIfEmpty(getUserInformationFromAPI(userId))
    }

    override fun getUserInformationFromAPI(userId: Int): Observable<UserInformation> {
        userInformation = UserInformation()
        return Observable.just(userInformation)
    }

    override fun getUserInformationFromDB(userId: Int): Observable<UserInformation> {
        return Observable.just(userInformation)
    }
}