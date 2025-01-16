package com.example.testcallapi.network.product

import com.example.testcallapi.network.product.model.ProductListResponse
import com.example.testcallapi.network.product.model.ProductResponse
import retrofit2.Response
import retrofit2.http.GET

interface ProductClient {
    @GET("/products")
    suspend fun getAllProducts(): Response<ProductListResponse>

    @GET("/products/{id}")
    suspend fun getProductById(id: Int): Response<ProductResponse>

}