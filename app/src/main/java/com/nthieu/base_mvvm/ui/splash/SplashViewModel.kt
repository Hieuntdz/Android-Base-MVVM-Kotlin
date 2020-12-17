package com.nthieu.base_mvvm.ui.splash


import com.nthieu.base_mvvm.base.BaseViewModel
import com.nthieu.base_mvvm.data.Repository

class SplashViewModel : BaseViewModel() {

    fun getAccessToken(): String {
       return Repository.getAccessToken()
    }
}