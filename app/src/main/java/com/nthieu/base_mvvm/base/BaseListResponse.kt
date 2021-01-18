package com.nthieu.base_mvvm.base

/**
 * Aitruck
 * Created by Nguyen Trung Hieu on 1/18/2021.
 * Phone, telegram : 0372.810.001.
 * Email : nthieuhpcntt@gmail.com
 */

import com.nthieu.base_mvvm.utils.DefineResponseStatus

open class BaseListResponse<T> private constructor(
    var status: Int,
    data: List<T>?,
    var error: Throwable?
) {
    var data: MutableList<T> = mutableListOf()

    init {
        data?.let { this.data.addAll(it) }
    }

    fun loading(): BaseListResponse<T> {
        return BaseListResponse<T>(DefineResponseStatus.LOADING, null, null)
    }

    fun success(data: List<T>): BaseListResponse<T> {
        return BaseListResponse(DefineResponseStatus.SUCCESS, data, null)
    }

    fun error(throwable: Throwable): BaseListResponse<T> {
        return BaseListResponse<T>(DefineResponseStatus.ERROR, null, throwable)
    }
}