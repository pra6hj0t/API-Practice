package com.example.apispractice

import retrofit2.Call
import retrofit2.http.GET

interface Interface {

    @GET("Products")
    fun getProductData() : Call<Data>
}