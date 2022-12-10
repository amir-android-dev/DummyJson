package com.ema.dummyjson.data.retrofit

import com.ema.dummyjson.model.Product
import com.ema.dummyjson.model.Products
import retrofit2.Call
import retrofit2.http.GET

interface ProductService {

    @GET("products")
    fun getAllProducts(): Call<Products>
}