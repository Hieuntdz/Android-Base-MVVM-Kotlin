package com.nthieu.base_mvvm.ui.home

import androidx.lifecycle.MutableLiveData
import com.nthieu.base_mvvm.base.BaseObjectResponse
import com.nthieu.base_mvvm.base.BaseViewModel
import com.nthieu.base_mvvm.data.Repository
import com.nthieu.base_mvvm.data.model.LoginResponse

class HomeViewModel : BaseViewModel() {

    private var homeData = MutableLiveData<BaseObjectResponse<LoginResponse?>>()
    val getHomeData: MutableLiveData<BaseObjectResponse<LoginResponse?>> get() = homeData

    fun loadHomeData(accessToken: String) {
        compositeDisposable.add(
            Repository.getHomeData(accessToken)
                ?.doOnSubscribe {
                    homeData.value = BaseObjectResponse<LoginResponse>().loading()
                }
                ?.subscribe(
                    { data ->
                        homeData.value = BaseObjectResponse<LoginResponse>().success(data)
                    },
                    { throwable ->
                        homeData.value = BaseObjectResponse<LoginResponse>().error(throwable)
                    })
        )
    }
}