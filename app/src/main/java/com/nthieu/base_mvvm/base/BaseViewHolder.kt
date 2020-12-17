package com.nthieu.base_mvvm.base

import android.view.View
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

abstract class BaseViewHolder<T, V : ViewDataBinding>(v: V) : RecyclerView.ViewHolder(v.root) {

    abstract fun bindData(data: T?)
}