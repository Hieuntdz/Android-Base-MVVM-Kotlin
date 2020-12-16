package com.nthieu.base_mvvm.ui.splash

import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.nthieu.base_mvvm.R
import com.nthieu.base_mvvm.base.BaseFragment
import com.nthieu.base_mvvm.databinding.FragmentSplashBinding
import com.nthieu.base_mvvm.utils.Logger
import java.util.*
import kotlin.concurrent.schedule

class SplashFragment : BaseFragment<FragmentSplashBinding>() {
    val TAG: String = SplashFragment::javaClass.name
    lateinit var splashViewModel: SplashViewModel
    override fun layoutId(): Int {
        return R.layout.fragment_splash
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        splashViewModel = ViewModelProviders.of(this,viewModelFactory).get(SplashViewModel::class.java)
        init()
    }

    private fun init() {
        var isAlreadyLogin = splashViewModel.checkLogin()
        Timer().schedule(2000) {
            Logger.debug(TAG, "End Splash $isAlreadyLogin")
        }
    }
}