package com.nthieu.base_mvvm.data

import android.content.SharedPreferences
import com.nthieu.base_mvvm.data.network.ApiInterface
import com.nthieu.base_mvvm.utils.AppSharePres
import com.nthieu.base_mvvm.utils.Define
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class Repository {
    var apiInterface: ApiInterface
    var sharePres: SharedPreferences

    @Inject
    constructor(apiInterface: ApiInterface, sharePres: SharedPreferences) {
        this.apiInterface = apiInterface
        this.sharePres = sharePres
    }

    fun isAlreadyLogin(): Boolean {
        return sharePres.getBoolean(AppSharePres.IS_ALREADY_LOGIN,false)
    }

}