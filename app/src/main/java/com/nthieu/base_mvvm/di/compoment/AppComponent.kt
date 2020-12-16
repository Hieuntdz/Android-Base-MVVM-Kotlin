package com.nthieu.base_mvvm.di.compoment

import android.app.Application
import com.nthieu.base_mvvm.MyApplication
import com.nthieu.base_mvvm.di.module.ActivityBindingModule
import com.nthieu.base_mvvm.di.module.FragmentBidingModule
import com.nthieu.base_mvvm.di.module.NetWorkModule
import com.nthieu.base_mvvm.di.module.ViewModelModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        ActivityBindingModule::class,
        FragmentBidingModule::class,
        ViewModelModule::class,
        NetWorkModule::class]
)
interface AppComponent {
    fun inject(baseApplication: MyApplication?)

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application?): Builder?
        fun build(): AppComponent?
    }
}
