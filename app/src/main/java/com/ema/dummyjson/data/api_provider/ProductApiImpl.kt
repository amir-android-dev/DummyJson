package com.ema.dummyjson.data.api_provider

import com.ema.dummyjson.data.Resource
import com.ema.dummyjson.data.retrofit.Remote
import com.ema.dummyjson.model.Product
import com.ema.dummyjson.model.Products
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProductApiImpl : ProductAPI {


    override fun getAllProducts(result: (data: Resource<List<Product>>) -> Unit) {
        val call = Remote.retrofit.getAllProducts()

        call.enqueue(object : Callback<Products> {
            override fun onResponse(call: Call<Products>, response: Response<Products>) {
                val products = response.body()
                val list = products?.products
                list?.let {
                    result(Resource.Success(it))
                }
            }

            override fun onFailure(call: Call<Products>, t: Throwable) {
                result(Resource.Error(t))
            }

        })
    }
}