package com.nthieu.base_mvvm.data.network

/**
 * Aitruck
 * Created by Nguyen Trung Hieu on 1/18/2021.
 * Phone, telegram : 0372.810.001.
 * Email : nthieuhpcntt@gmail.com
 */

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