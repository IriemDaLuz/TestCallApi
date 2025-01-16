package com.example.testcallapi.network.product.model

import com.example.testcallapi.network.product.ProductService

class ProductRepository {
    val api = ProductService()
    suspend fun getAllProducts(): ProductListResponse {
        return api.getAllProducts()
    }
}