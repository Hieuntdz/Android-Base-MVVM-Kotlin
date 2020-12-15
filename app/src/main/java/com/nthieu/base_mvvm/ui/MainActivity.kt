package com.nthieu.base_mvvm.ui

import android.content.Context
import android.os.Bundle
import android.os.PersistableBundle
import android.util.AttributeSet
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.nthieu.base_mvvm.R
import com.nthieu.base_mvvm.base.BaseActivity
import com.nthieu.base_mvvm.databinding.ActivityMainBinding
import com.nthieu.base_mvvm.utils.Logger

class MainActivity : BaseActivity<ActivityMainBinding>() {


    override fun layoutId(): Int {
      return R.layout.activity_main
    }

    override fun fragmentContainerId(): Int {
       return R.id.container
    }

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
    }

    override fun initView() {
        binding?.btn1?.text = "AAAAAAAAAAAAAAA"
        binding?.btn1?.setOnClickListener{
            Logger.debug("dsfsdfsdf","button 1 click")
            fragmentController?.addFragment(Fragment1(),null)
        }

        binding?.btn2?.setOnClickListener(View.OnClickListener {
            fragmentController?.addFragment(Fragment2(),null)
        })

        binding?.btn3?.setOnClickListener(View.OnClickListener {
            fragmentController?.replaceFragment(Fragment3(),null)
        })
    }


}