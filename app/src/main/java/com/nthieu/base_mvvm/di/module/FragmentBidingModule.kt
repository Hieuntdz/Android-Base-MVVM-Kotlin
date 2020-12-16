package com.nthieu.base_mvvm.di.module

import com.nthieu.base_mvvm.ui.home.HomeFragment
import com.nthieu.base_mvvm.ui.login.LoginFragment
import com.nthieu.base_mvvm.ui.splash.SplashFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract  class FragmentBidingModule {
    @ContributesAndroidInjector
    abstract fun bindSplash(): SplashFragment?

    @ContributesAndroidInjector
    abstract fun bindLogin(): LoginFragment?

    @ContributesAndroidInjector
    abstract fun bindHome(): HomeFragment?
}