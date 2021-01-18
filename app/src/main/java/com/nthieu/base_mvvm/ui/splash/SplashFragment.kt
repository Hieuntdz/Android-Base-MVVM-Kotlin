package com.nthieu.base_mvvm.ui.splash

/**
 * Aitruck
 * Created by Nguyen Trung Hieu on 1/18/2021.
 * Phone, telegram : 0372.810.001.
 * Email : nthieuhpcntt@gmail.com
 */

import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.nthieu.base_mvvm.R
import com.nthieu.base_mvvm.base.BaseFragment
import com.nthieu.base_mvvm.databinding.FragmentSplashBinding
import com.nthieu.base_mvvm.ui.MainActivity
import com.nthieu.base_mvvm.ui.home.HomeFragment
import com.nthieu.base_mvvm.ui.login.LoginFragment
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
        splashViewModel = ViewModelProviders.of(this).get(SplashViewModel::class.java)
        init()
    }

    private fun init() {
        val accessToken = splashViewModel.getAccessToken()
        Timer().schedule(2000) {
            Logger.debug(TAG, "End Splash $accessToken")
            if (accessToken.isNotEmpty()) {
                (activity as MainActivity).fragmentController?.replaceFragment(
                    HomeFragment(), null,
                    (activity as MainActivity).fragmentContainerId()
                )
            } else {
                (activity as MainActivity).fragmentController?.replaceFragment(
                    LoginFragment(),
                    null,
                    (activity as MainActivity).fragmentContainerId()
                )
            }
        }
    }
}