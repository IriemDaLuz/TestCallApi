package com.example.testcallapi

import android.content.Context
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue

import androidx.compose.material3.Text
import com.example.testcallapi.network.product.model.ProductResponse


@Composable
fun ProductListScreen(
    productViewModel: ProductViewModel,
    context: Context,
    innerPadding: PaddingValues
    ){
    val isLoading:Boolean by productViewModel.isLoading.observeAsState(initial = true)
    if (isLoading){
        productViewModel.getAllProducts()
        LoadingScreen()
    }else{
        CompleteProductListScreen(productViewModel.productList.value!!)
    }
}

@Composable
fun CompleteProductListScreen(productList: List<ProductResponse>){
    Text("Ya Cargó")
}