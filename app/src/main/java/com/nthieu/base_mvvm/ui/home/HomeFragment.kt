package com.nthieu.base_mvvm.ui.home

/**
 * Aitruck
 * Created by Nguyen Trung Hieu on 1/18/2021.
 * Phone, telegram : 0372.810.001.
 * Email : nthieuhpcntt@gmail.com
 */

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide.init
import com.nthieu.base_mvvm.R
import com.nthieu.base_mvvm.base.BaseFragment
import com.nthieu.base_mvvm.base.BaseObjectResponse
import com.nthieu.base_mvvm.data.model.LoginResponse
import com.nthieu.base_mvvm.databinding.FragmentHomeBinding
import com.nthieu.base_mvvm.ui.MainActivity
import com.nthieu.base_mvvm.utils.DefineResponseStatus
import com.nthieu.base_mvvm.utils.Logger

class HomeFragment : BaseFragment<FragmentHomeBinding>() {
    val TAG = HomeFragment::class.java.name

    override fun layoutId(): Int {
        return R.layout.fragment_home
    }

    lateinit var viewModel: HomeViewModel
    lateinit var homeAdapter : HomeAdapter
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        init()
        initViewModel()
        loadData()
    }

    private fun init() {
        homeAdapter = HomeAdapter()
        binding.rvContent.layoutManager = LinearLayoutManager(context)
        binding.rvContent.adapter = homeAdapter
    }

    private fun initViewModel() {
        viewModel = ViewModelProviders.of(this).get(HomeViewModel::class.java)

        viewModel.getHomeData.observe(viewLifecycleOwner, handleGetHomeData)
    }

    private val handleGetHomeData = Observer<BaseObjectResponse<LoginResponse?>> { response ->
        val status = response.status
        Logger.debug(TAG, "handleGetHomeData status $status")
        when (status) {
            DefineResponseStatus.LOADING -> showLoading()
            DefineResponseStatus.SUCCESS -> {
                hideLoading()
                loadHomeData(response.data)
            }
            DefineResponseStatus.ERROR -> response.error?.let {
                hideLoading()
                (activity as MainActivity).handleNetworkError(it, true)
            }
        }
    }

    private fun loadHomeData(data: LoginResponse?) {
        if (data == null) {
            return
        }
        homeAdapter.setData(data.data)
    }

    private fun loadData() {
        viewModel.loadHomeData("dsfsd")
    }
}