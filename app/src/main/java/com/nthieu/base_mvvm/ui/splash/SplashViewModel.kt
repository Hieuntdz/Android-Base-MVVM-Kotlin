package com.nthieu.base_mvvm.ui.splash

import com.nthieu.base_mvvm.base.BaseViewModel
import com.nthieu.base_mvvm.data.Repository
import javax.inject.Inject


class SplashViewModel : BaseViewModel {

    var repository : Repository

    @Inject
    constructor(repository: Repository){
        this.repository = repository
    }

    fun checkLogin(): Boolean {
        return  repository.isAlreadyLogin()
    }
}