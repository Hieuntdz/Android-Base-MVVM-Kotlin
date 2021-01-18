package com.nthieu.base_mvvm.ui.login

/**
 * Aitruck
 * Created by Nguyen Trung Hieu on 1/18/2021.
 * Phone, telegram : 0372.810.001.
 * Email : nthieuhpcntt@gmail.com
 */

import androidx.lifecycle.MutableLiveData
import com.nthieu.base_mvvm.base.BaseObjectResponse
import com.nthieu.base_mvvm.base.BaseViewModel
import com.nthieu.base_mvvm.data.Repository
import com.nthieu.base_mvvm.data.model.LoginResponse

class LoginViewModel : BaseViewModel() {

    var loginResponse: MutableLiveData<BaseObjectResponse<LoginResponse>> = MutableLiveData()

    fun login(userName: String, passWord: String) {
        handleLoginSuccess()
    }

    private fun handleLoginSuccess() {
        Repository.saveAccessToken("sdfsdfsdf")
    }

    fun handleLoginFailed() {

    }
}