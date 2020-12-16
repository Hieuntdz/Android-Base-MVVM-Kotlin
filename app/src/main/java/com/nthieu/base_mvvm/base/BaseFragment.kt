package com.nthieu.base_mvvm.base

import android.os.Bundle
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import java.io.Serializable
import java.util.*
import javax.inject.Inject

abstract class BaseFragment<T : ViewDataBinding> : Fragment() {

    abstract fun layoutId(): Int
    open fun onBackPress() {}

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var binding : T

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

}