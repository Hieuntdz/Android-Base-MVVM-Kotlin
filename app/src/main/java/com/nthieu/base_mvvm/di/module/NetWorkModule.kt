package com.nthieu.base_mvvm.di.module

import android.content.Context
import android.content.SharedPreferences
import com.google.gson.GsonBuilder
import com.nthieu.base_mvvm.BuildConfig
import com.nthieu.base_mvvm.R
import com.nthieu.base_mvvm.data.network.ApiInterface
import com.nthieu.base_mvvm.data.network.NetworkCheckerInterceptor
import com.nthieu.base_mvvm.utils.AppSharePres
import com.nthieu.base_mvvm.utils.Define
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
class NetWorkModule {
    @Provides
    @Singleton
    fun provideApiInterface(okHttpClient: OkHttpClient): ApiInterface {
        val gson = GsonBuilder()
            .setLenient()
            .create()

        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()

        return retrofit.create(ApiInterface::class.java)
    }

    @Provides
    @Singleton
    fun createOkHttpClient(context: Context): OkHttpClient {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        var networkCheckerInterceptor: NetworkCheckerInterceptor =
            NetworkCheckerInterceptor(context)

        return OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .addInterceptor(networkCheckerInterceptor)
            .connectTimeout(Define.DEFAULT_TIMEOUT, TimeUnit.SECONDS)
            .readTimeout(Define.DEFAULT_TIMEOUT, TimeUnit.SECONDS)
            .build()
    }

    @Provides
    @Singleton
    fun provideSharePreferences(context: Context): SharedPreferences {
        return context.getSharedPreferences(
            AppSharePres.SHARE_PRES_NAME, Context.MODE_PRIVATE
        )
    }

}