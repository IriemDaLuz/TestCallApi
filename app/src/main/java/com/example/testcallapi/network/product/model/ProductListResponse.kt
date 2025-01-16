package com.example.testcallapi.network.product.model

import com.google.gson.annotations.SerializedName

data class ProductListResponse (
    @SerializedName("products") val productsList: List<ProductResponse>,
    @SerializedName("total") val total: Int,
    @SerializedName("skip") val skip: Int,
    @SerializedName("limit") val limit:Int

)