package com.nthieu.base_mvvm.base

/**
 * Aitruck
 * Created by Nguyen Trung Hieu on 1/18/2021.
 * Phone, telegram : 0372.810.001.
 * Email : nthieuhpcntt@gmail.com
 */

import android.view.View
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

abstract class BaseViewHolder<T, V : ViewDataBinding>(v: V) : RecyclerView.ViewHolder(v.root) {

    abstract fun bindData(data: T?)
}