package com.example.apispractice

data class Data(
    val limit: Int,
    val products: List<Product>,
    val skip: Int,
    val total: Int
)