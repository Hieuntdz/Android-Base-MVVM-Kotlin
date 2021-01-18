package com.nthieu.base_mvvm.utils

/**
 * Aitruck
 * Created by Nguyen Trung Hieu on 1/18/2021.
 * Phone, telegram : 0372.810.001.
 * Email : nthieuhpcntt@gmail.com
 */

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.LayoutInflater
import androidx.databinding.DataBindingUtil
import com.nthieu.base_mvvm.R
import com.nthieu.base_mvvm.databinding.DialogLoadingBinding

object DialogUtils {

    lateinit var context: Context

    private var dialogLoading: Dialog? = null
    fun showLoadingDialog(context: Context?) {
        if (context == null){
            return
        }
        this.context = context
        dialogLoading?.dismiss()
        val dialogBuilder = AlertDialog.Builder(context)
        val layoutInflater = LayoutInflater.from(context)
        val binding: DialogLoadingBinding =
            DataBindingUtil.inflate(layoutInflater, R.layout.dialog_loading, null, false)
        dialogBuilder.setView(binding.root)
        dialogBuilder.setCancelable(false)
        dialogLoading = dialogBuilder.create()
        dialogLoading?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialogLoading?.setCancelable(false)
        dialogLoading?.setCanceledOnTouchOutside(false)
        dialogLoading?.show()
    }

    fun hideDialogLoading() {
        dialogLoading?.dismiss()
    }
}