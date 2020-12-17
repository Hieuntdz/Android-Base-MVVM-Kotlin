package com.nthieu.base_mvvm.base

import android.os.Bundle
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import com.nthieu.base_mvvm.R
import com.nthieu.base_mvvm.data.network.NetworkCheckerInterceptor
import com.nthieu.base_mvvm.utils.DialogUtils
import com.nthieu.base_mvvm.utils.Helper
import com.nthieu.base_mvvm.utils.Logger
import retrofit2.HttpException
import java.io.Serializable
import java.lang.Exception
import java.util.*

abstract class BaseFragment<T : ViewDataBinding> : Fragment() {

    abstract fun layoutId(): Int
    open fun onBackPress() {}

    protected lateinit var binding : T

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, layoutId(), container, false)
        return binding.root
    }

    fun setData(data: HashMap<String, Any>) {

        if (data.isEmpty()) {
            arguments = Bundle()
            return
        }
        val bundle = Bundle()

        for ((key, value) in data) {
            when (value) {
                is String -> bundle.putString(key, value)
                is Int -> bundle.putInt(key, value)
                is Double -> bundle.putDouble(key, value)
                is Float -> bundle.putFloat(key, value)
                is Boolean -> bundle.putBoolean(key, value)
                is Parcelable -> bundle.putParcelable(key, value)
                is Serializable -> bundle.putSerializable(key, value)
            }
        }
    }

    fun showLoading(){
        DialogUtils.showLoadingDialog(context)
    }

    fun hideLoading(){
        DialogUtils.hideDialogLoading()
    }

    fun handleNetworkError(throwable: Throwable, isShowDialog: Boolean) {

        var errMessage = ""

        when (throwable) {
            is NetworkCheckerInterceptor.NoConnectivityException -> {
                errMessage = getString(R.string.no_internet)
                showNoInternetMessage(message = errMessage)
            }
            is HttpException -> {
                errMessage = try {
                    Logger.debug("Request Error ", throwable.response().toString())
                    getString(R.string.an_error_excuse)
                } catch (e: Exception) {
                    getString(R.string.request_timeout)
                }
            }
            else -> {
                errMessage = getString(R.string.request_timeout)
            }
        }

        if (isShowDialog && errMessage.isNotEmpty()) {
            showSnackBar(errMessage)
        }
    }

    private fun showNoInternetMessage(message: String) {
        showSnackBar(message)
    }

    private fun showSnackBar(message: String) {
        binding.root.let { Helper.showLongSnackBar(it, message) }
    }

}