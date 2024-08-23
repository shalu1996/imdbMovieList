package com.example.test

sealed class ViewState<T>(
    val data: T? = null,
    val message: String? = null
) {
    class SUCCESS<T>(data: T?) : ViewState<T>(data)
    class ERROR<T>(message: String?, data: T? = null) : ViewState<T>(data)
    class LOADING<T> : ViewState<T>()
}