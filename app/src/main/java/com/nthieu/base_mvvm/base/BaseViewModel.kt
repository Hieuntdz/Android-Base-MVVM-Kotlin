package com.nthieu.base_mvvm.base

import androidx.lifecycle.ViewModel
import io.reactivex.rxjava3.disposables.CompositeDisposable

open class BaseViewModel : ViewModel() {
    val compositeDisposable = CompositeDisposable()
}