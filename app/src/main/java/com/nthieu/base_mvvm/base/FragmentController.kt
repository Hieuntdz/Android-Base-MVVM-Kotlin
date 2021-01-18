package com.nthieu.base_mvvm.base

/**
 * Aitruck
 * Created by Nguyen Trung Hieu on 1/18/2021.
 * Phone, telegram : 0372.810.001.
 * Email : nthieuhpcntt@gmail.com
 */

import androidx.fragment.app.FragmentManager

class FragmentController<T : BaseFragment<*>>(
    private var fragmentManager: FragmentManager
) {
    private var fragmentList: MutableList<T> = mutableListOf()
    private var currentFragment: T? = null

    fun getCurrentFragment() : T? = currentFragment

    fun addFragment(fragment: T, data: HashMap<String, Any>?, layoutId:Int) {
        if (currentFragment?.javaClass?.name.equals(fragment.javaClass.name)) {
            return
        }
        data?.let { fragment.setData(it) }
        fragmentManager.beginTransaction().add(layoutId, fragment).commit()
        currentFragment = fragment
        fragmentList.add(fragment)
    }

    fun addFragmentToBackStack(fragment: T, data: HashMap<String, Any>?, layoutId:Int) {
        if (currentFragment?.javaClass?.name.equals(fragment.javaClass.name)) {
            return
        }
        data?.let { fragment.setData(it) }
        currentFragment = fragment
        fragmentList.add(fragment)
        fragmentManager.beginTransaction().add(layoutId, fragment).addToBackStack(fragment.javaClass.name).commit()
    }

    fun replaceFragment(fragment: T, data: HashMap<String, Any>?, layoutId:Int) {
        if (currentFragment?.javaClass?.name.equals(fragment.javaClass.name)) {
            return
        }

        data?.let { fragment.setData(it) }

        fragmentList.remove(currentFragment)
        currentFragment = fragment
        fragmentList.add(fragment)
        fragmentManager.beginTransaction().replace(layoutId, fragment).commit()
    }
}