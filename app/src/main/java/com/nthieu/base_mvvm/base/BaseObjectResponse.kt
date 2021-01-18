package com.nthieu.base_mvvm.base

/**
 * Aitruck
 * Created by Nguyen Trung Hieu on 1/18/2021.
 * Phone, telegram : 0372.810.001.
 * Email : nthieuhpcntt@gmail.com
 */

import com.nthieu.base_mvvm.utils.DefineResponseStatus

class BaseObjectResponse<T> {

    var status: Int? = null
    var data: T? = null
    var error: Throwable? = null

    constructor(status: Int, data: T, error: Throwable?) {
        this.status = status
        this.data = data
        this.error = error
    }

    constructor()

    fun loading(): BaseObjectResponse<T?> {
        return BaseObjectResponse(DefineResponseStatus.LOADING, null, null)
    }

    fun success(data: T): BaseObjectResponse<T?> {
        return BaseObjectResponse(DefineResponseStatus.SUCCESS, data, null)
    }

    fun error(throwable: Throwable): BaseObjectResponse<T?> {
        return BaseObjectResponse(DefineResponseStatus.ERROR, null, throwable)
    }
}
