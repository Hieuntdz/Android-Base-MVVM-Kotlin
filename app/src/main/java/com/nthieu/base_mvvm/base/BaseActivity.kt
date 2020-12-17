package com.nthieu.base_mvvm.base

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.nthieu.base_mvvm.R
import com.nthieu.base_mvvm.data.Repository
import com.nthieu.base_mvvm.data.local.AppRoomDatabase
import com.nthieu.base_mvvm.data.network.ApiClient
import com.nthieu.base_mvvm.data.network.NetworkCheckerInterceptor
import com.nthieu.base_mvvm.utils.*
import retrofit2.HttpException
import java.lang.Exception

abstract class BaseActivity<T : ViewDataBinding> : AppCompatActivity() {

    abstract fun layoutId(): Int
    abstract fun fragmentContainerId(): Int
    abstract fun initView()

    private var lastClickTime = System.currentTimeMillis()

    var fragmentController: FragmentController<BaseFragment<*>>? = null

    lateinit var binding: T

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, layoutId())
        fragmentController = FragmentController(supportFragmentManager)

        Repository.setRoomDataBase(AppRoomDatabase.getDataBase(this))
        Repository.setApiInterface(ApiClient.getInstance(this))
        val sharedPreferences: SharedPreferences = this.getSharedPreferences(
            DefineAppSharePres.SHARE_PRES_NAME,
            Context.MODE_PRIVATE
        )
        Repository.setSharedPreferences(sharedPreferences)

        initView()
    }

    override fun onBackPressed() {
        if (fragmentController?.getCurrentFragment() != null) {
            val fragment = supportFragmentManager.findFragmentById(fragmentContainerId())
            if (fragment is BaseFragment<*>) {
                fragment.onBackPress()
            }
        }
        super.onBackPressed()
    }

    protected fun checkDoubleClick(): Boolean {
        if (System.currentTimeMillis() - lastClickTime > Define.CLICK_TIME_INTERVAL) {
            lastClickTime = System.currentTimeMillis()
            return true
        }
        return false
    }


    open fun handleNetworkError(throwable: Throwable, isShowDialog: Boolean) {

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

    fun showLoading() {
        DialogUtils.showLoadingDialog(this)
    }

    fun hideLoading() {
        DialogUtils.hideDialogLoading()
    }
}