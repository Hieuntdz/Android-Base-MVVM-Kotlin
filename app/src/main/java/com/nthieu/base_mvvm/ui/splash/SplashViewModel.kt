package com.nthieu.base_mvvm.ui.splash

/**
 * Aitruck
 * Created by Nguyen Trung Hieu on 1/18/2021.
 * Phone, telegram : 0372.810.001.
 * Email : nthieuhpcntt@gmail.com
 */

import com.nthieu.base_mvvm.base.BaseViewModel
import com.nthieu.base_mvvm.data.Repository

class SplashViewModel : BaseViewModel() {

    fun getAccessToken(): String {
       return Repository.getAccessToken()
    }
}