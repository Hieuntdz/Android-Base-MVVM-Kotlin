package com.nthieu.base_mvvm.data.network

import com.nthieu.base_mvvm.data.model.LoginResponse
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import java.util.*

interface ApiInterface {

    @GET("v2/home/banners/v2")
    fun login() : Single<LoginResponse>

    @GET("v2/home/banners/v2")
    fun getHomeData() : Single<LoginResponse>
}