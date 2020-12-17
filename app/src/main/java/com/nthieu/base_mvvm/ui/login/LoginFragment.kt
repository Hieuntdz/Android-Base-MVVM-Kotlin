package com.nthieu.base_mvvm.ui.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.nthieu.base_mvvm.R
import com.nthieu.base_mvvm.base.BaseFragment
import com.nthieu.base_mvvm.databinding.FragmentLoginBinding
import com.nthieu.base_mvvm.ui.Fragment1
import com.nthieu.base_mvvm.ui.Fragment2
import com.nthieu.base_mvvm.ui.MainActivity
import com.nthieu.base_mvvm.ui.home.HomeFragment
import com.nthieu.base_mvvm.utils.Logger

class LoginFragment : BaseFragment<FragmentLoginBinding>() {
    val TAG = LoginFragment::class.java.name
    override fun layoutId(): Int {
      return R.layout.fragment_login
    }

    override fun onBackPress() {
        super.onBackPress()
        Logger.debug(TAG,"LoginFragment onBackPress")
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnLogin.setOnClickListener {
            (activity as MainActivity).fragmentController?.replaceFragment(
                HomeFragment(),
                null,
                (activity as MainActivity).fragmentContainerId()
            )
        }
    }
}