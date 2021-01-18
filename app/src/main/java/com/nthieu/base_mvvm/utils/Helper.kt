package com.nthieu.base_mvvm.utils

/**
 * Aitruck
 * Created by Nguyen Trung Hieu on 1/18/2021.
 * Phone, telegram : 0372.810.001.
 * Email : nthieuhpcntt@gmail.com
 */

import android.os.Message
import android.view.View
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.google.android.material.snackbar.Snackbar

object Helper {

    fun showLongSnackBar(parentLayout: View, message: String) {
        Snackbar.make(parentLayout, message, Snackbar.LENGTH_LONG).show()
    }

    fun showShortSnackBar(parentLayout: View, message: String) {
        Snackbar.make(parentLayout, message, Snackbar.LENGTH_LONG).show()
    }

    fun loadImage(image: ImageView, url: String) {
        Glide.with(image.context).load(url).centerCrop().into(image)
    }
}