package com.example.recipesproject.base.vm

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.cancel

open class BaseViewModel : ViewModel() {

    protected val coroutineContext = CoroutineScope(Dispatchers.Main + Job())

    override fun onCleared() {
        coroutineContext.cancel()
    }
}