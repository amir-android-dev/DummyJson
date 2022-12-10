package com.ema.dummyjson.data.api_provider

import com.ema.dummyjson.data.Resource
import com.ema.dummyjson.model.Product

interface ProductAPI {
    fun getAllProducts(result: (Resource<List<Product>>) -> Unit)
}