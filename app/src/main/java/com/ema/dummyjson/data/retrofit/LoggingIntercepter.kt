package com.ema.dummyjson.data.retrofit

import okhttp3.Interceptor
import okhttp3.Response

class LoggingIntercepter:Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {

        val request = chain.request().newBuilder()
            .addHeader("kminchelle","0lelplR")
            .build()

        return chain.proceed(request)
    }
}