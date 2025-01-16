package com.example.testcallapi.network.product.model

import com.google.gson.annotations.SerializedName

data class ProductResponse(
    @SerializedName("id") var id:Int,
    @SerializedName("title") var title:String,
    @SerializedName("description") var description:String,
    @SerializedName("price") var price:Double,
    @SerializedName("discountPercentage") var discountPercentage:Double,
    @SerializedName("rating") var rating:Double,
    @SerializedName("stock") var stock:Int,
    @SerializedName("brand") var brand:String,
    @SerializedName("category") var category:String,
    @SerializedName("thumbnail") var thumbnail:String,
)