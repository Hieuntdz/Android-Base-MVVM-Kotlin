package com.nthieu.base_mvvm.base

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.nthieu.base_mvvm.utils.Define

abstract class BaseActivity<T : ViewDataBinding> : AppCompatActivity() {

    abstract fun layoutId(): Int
    abstract fun fragmentContainerId(): Int
    abstract fun initView()

    private var lastClickTime = System.currentTimeMillis()

    var fragmentController: FragmentController<BaseFragment<*>>? = null

    protected var binding: T ?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, layoutId())
        fragmentController = FragmentController(supportFragmentManager, fragmentContainerId())
        initView()
    }

    override fun onBackPressed() {
        super.onBackPressed()
        (supportFragmentManager.findFragmentById(layoutId()) as BaseFragment<*>).onBackPress()
    }

    protected fun checkDoubleClick(): Boolean {
        if (System.currentTimeMillis() - lastClickTime > Define.CLICK_TIME_INTERVAL) {
            lastClickTime = System.currentTimeMillis()
            return true
        }
        return false
    }
}