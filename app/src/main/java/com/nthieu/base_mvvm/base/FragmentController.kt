package com.nthieu.base_mvvm.base

import androidx.fragment.app.FragmentManager

class FragmentController<T : BaseFragment<*>> {
    private var layoutId: Int = 0
    private lateinit var fragmentManager: FragmentManager
    private lateinit var fragmentList: MutableList<T>
    private var currentFragment: T? = null

    constructor(fragmentManager: FragmentManager, layoutId: Int) {
        this.fragmentManager = fragmentManager
        this.layoutId = layoutId
    }

    fun addFragment(fragment: T, data: HashMap<String, Any>?) {
        if (currentFragment?.javaClass?.name.equals(fragment.javaClass.name)) {
            return
        }
        data?.let { fragment.setData(it) }
        fragmentManager.beginTransaction().add(layoutId, fragment)
            .addToBackStack(fragment.javaClass.name).commit()
        currentFragment = fragment
        fragmentList.add(fragment)
    }

    fun replaceFragment(fragment: T, data: HashMap<String, Any>?) {
        if (currentFragment?.javaClass?.name.equals(fragment.javaClass.name)) {
            return
        }

        data?.let { fragment.setData(it) }
        val fragmentPopped =
            fragmentManager.popBackStackImmediate(currentFragment?.javaClass?.name, 0)
        if (!fragmentPopped) {
            fragmentManager.beginTransaction().replace(layoutId, fragment)
                .addToBackStack(fragment.javaClass.name).commit()
        }else{
            fragmentList.remove(fragment)
            currentFragment = fragment
            fragmentList.add(fragment)
            addFragment(fragment,data)
        }
    }
}