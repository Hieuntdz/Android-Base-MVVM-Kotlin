package com.nthieu.base_mvvm.data.network

import android.content.Context
import com.google.gson.GsonBuilder
import com.nthieu.base_mvvm.BuildConfig
import com.nthieu.base_mvvm.utils.Define
import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object ApiClient {

    private var apiInterface: ApiInterface? = null

    fun getInstance(context: Context): ApiInterface {
        if (apiInterface == null) {
            apiInterface = createApiInterface(context)
        }
        return apiInterface!!
    }

    private fun createApiInterface(context: Context): ApiInterface {
        val gson = GsonBuilder()
            .setLenient()
            .create()

        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .client(createOkHttpClient(context))
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()

        return retrofit.create(ApiInterface::class.java)
    }

    private fun createOkHttpClient(context: Context): OkHttpClient {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        val networkCheckerInterceptor = NetworkCheckerInterceptor(context)
        return OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .addInterceptor(networkCheckerInterceptor)
            .connectTimeout(Define.DEFAULT_TIMEOUT, TimeUnit.SECONDS)
            .readTimeout(Define.DEFAULT_TIMEOUT, TimeUnit.SECONDS)
            .build()
    }
}