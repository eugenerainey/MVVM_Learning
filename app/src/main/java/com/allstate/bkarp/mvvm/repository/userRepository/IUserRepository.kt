package com.allstate.bkarp.mvvm.repository.userRepository

import com.allstate.bkarp.mvvm.objects.UserInformation
import io.reactivex.Observable

interface IUserRepository {

    fun getUserInformation(userId: Int): Observable<UserInformation>
    fun getUserInformationFromDB(userId: Int): Observable<UserInformation>
    fun getUserInformationFromAPI(userId: Int): Observable<UserInformation>
}