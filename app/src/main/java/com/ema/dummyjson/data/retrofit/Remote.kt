package com.ema.dummyjson.data.retrofit

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Remote {
    private const val BASE_URL = "https://dummyjson.com/"
    private val client = OkHttpClient.Builder().addInterceptor(LoggingIntercepter()).build()

    val retrofit: ProductService = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(BASE_URL)
        .client(client)
        .build()
        .create(ProductService::class.java)
}

