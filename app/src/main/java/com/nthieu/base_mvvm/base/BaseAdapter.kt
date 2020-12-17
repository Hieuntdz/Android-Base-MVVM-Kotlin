package com.nthieu.base_mvvm.base

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import java.util.*


abstract class BaseAdapter<T : ViewDataBinding, V : BaseViewHolder<*, *>, D> :
    RecyclerView.Adapter<V>() {
    lateinit var binding: T
    private var dataList: MutableList<D> = mutableListOf()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): V {
        val layoutInflater = LayoutInflater.from(parent.context)
        binding = DataBindingUtil.inflate(layoutInflater, layoutId, parent, false)
        return onActualCreateViewHolder(binding)
    }

    override fun onBindViewHolder(holder: V, position: Int) {
        onActualBindViewHolder(holder, position)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    fun setData(data: List<D>?) {
        data?.let {
            dataList.addAll(it.toMutableList())
            notifyDataSetChanged()
        }
    }

    fun addItems(items: List<D>?) {
        items?.toMutableList()?.let {
            dataList.addAll(it)
            notifyDataSetChanged()
        }
    }

    fun addItem(item: D) {
        dataList.add(item)
        notifyItemChanged(dataList.size)
    }

    fun removeItem(index: Int) {
        if (index < 0 || index >= dataList.size) {
            return
        }
        dataList.removeAt(index)
        notifyItemRemoved(index)
    }

    fun getItem(position: Int): D {
        return dataList[position]
    }

    abstract val layoutId: Int

    abstract fun onActualCreateViewHolder(binding: T?): V
    abstract fun onActualBindViewHolder(holder: V, position: Int)
}
