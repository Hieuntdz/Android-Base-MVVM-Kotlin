package com.nthieu.base_mvvm.data

/**
 * Aitruck
 * Created by Nguyen Trung Hieu on 1/18/2021.
 * Phone, telegram : 0372.810.001.
 * Email : nthieuhpcntt@gmail.com
 */

import android.content.SharedPreferences
import androidx.room.RoomDatabase
import com.nthieu.base_mvvm.data.local.AppRoomDatabase
import com.nthieu.base_mvvm.data.model.LoginResponse
import com.nthieu.base_mvvm.data.network.ApiInterface
import com.nthieu.base_mvvm.utils.DefineAppSharePres
import com.nthieu.base_mvvm.utils.DefineRoomDataBase
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers

object Repository {
    private lateinit var sharePres: SharedPreferences
    private lateinit var apiInterface: ApiInterface
    private lateinit var localDataBase: AppRoomDatabase
    private lateinit var editor: SharedPreferences.Editor


    fun setSharedPreferences(sharedPreferences: SharedPreferences) {
        this.sharePres = sharedPreferences
        this.editor = sharedPreferences.edit()
    }

    fun setApiInterface(apiInterface: ApiInterface) {
        this.apiInterface = apiInterface
    }

    fun setRoomDataBase(database: AppRoomDatabase) {
        this.localDataBase = database
    }

    fun getAccessToken(): String {
        return sharePres.getString(DefineAppSharePres.ACCESS_TOKEN, "")!!
    }

    fun saveAccessToken(accessToken: String) {
        editor.putString(DefineAppSharePres.ACCESS_TOKEN, accessToken)
    }

    fun login(userName: String, passWord: String): Single<LoginResponse>? {
        return apiInterface.login()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }

    fun getHomeData(accessToken: String): Single<LoginResponse>? {
        return apiInterface.login()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }
}