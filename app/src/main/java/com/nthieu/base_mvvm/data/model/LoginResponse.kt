package com.nthieu.base_mvvm.data.model

/**
 * Aitruck
 * Created by Nguyen Trung Hieu on 1/18/2021.
 * Phone, telegram : 0372.810.001.
 * Email : nthieuhpcntt@gmail.com
 */

data class LoginResponse(
    val data: List<Data>
)

data class Data(
    val content: String,
    val id: Int,
    val image_url: String,
    val mobile_url: String,
    val ratio: Double,
    val thumbnail_url: String,
    val title: String,
    val url: String
)