package com.nthieu.base_mvvm.ui.home

import androidx.databinding.ViewDataBinding
import com.nthieu.base_mvvm.R
import com.nthieu.base_mvvm.base.BaseAdapter
import com.nthieu.base_mvvm.base.BaseViewHolder
import com.nthieu.base_mvvm.data.model.Data
import com.nthieu.base_mvvm.data.model.LoginResponse
import com.nthieu.base_mvvm.databinding.ItemHomeBinding

class HomeAdapter : BaseAdapter<ItemHomeBinding, HomeViewHolder, Data>() {
    override val layoutId: Int
        get() = R.layout.item_home


    override fun onActualBindViewHolder(holder: HomeViewHolder, position: Int) {
        holder.bindData(getItem(position))
    }

    override fun onActualCreateViewHolder(binding: ItemHomeBinding?): HomeViewHolder {
        return HomeViewHolder(binding!!)
    }
}

class HomeViewHolder(binding: ItemHomeBinding) : BaseViewHolder<Data, ItemHomeBinding>(binding) {

    var mBinding = binding
    override fun bindData(data: Data?) {
        if (data == null) {
            return
        }
        mBinding.tvContent.text = data.title
    }
}
