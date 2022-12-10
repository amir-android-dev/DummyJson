package com.ema.dummyjson.data

sealed class Resource<out T>{
    data class Error(val throwable: Throwable) : Resource<Nothing>()
    data class Success<T>(val result: T) : Resource<T>()
    object SuccessNoBody : Resource<Nothing>()
}