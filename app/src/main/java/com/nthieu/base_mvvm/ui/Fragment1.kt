package com.nthieu.base_mvvm.ui

import android.nfc.Tag
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.nthieu.base_mvvm.R
import com.nthieu.base_mvvm.base.BaseFragment
import com.nthieu.base_mvvm.databinding.Fragment1Binding
import com.nthieu.base_mvvm.utils.Logger

class Fragment1 : BaseFragment<Fragment1Binding>() {

    final val TAG : String = this.javaClass.simpleName

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_1, container, false)
    }


    override fun layoutId(): Int {
        return R.layout.fragment_1
    }

    override fun onBackPress() {
        super.onBackPress()
        Logger.debug(TAG,"$TAG onBackPress")
    }
}