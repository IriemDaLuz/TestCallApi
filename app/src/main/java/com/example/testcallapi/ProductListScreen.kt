package com.example.testcallapi

import android.content.Context
import android.widget.Toast
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import com.example.testcallapi.data.ProductDBViewModel
import com.example.testcallapi.data.ProductViewModel
import com.example.testcallapi.data.db.productResponseToProduct
import com.example.testcallapi.network.product.model.ProductResponse


@Composable
fun ProductListScreen(
    productViewModel: ProductViewModel,
    databaseViewModel: ProductDBViewModel,
    context: Context
) {
    val isLoading: Boolean by productViewModel.isLoading.observeAsState(initial = true)
    if (isLoading) {
        productViewModel.getAllProducts()
        LoadingScreen()
    } else {
        ProductListView("Listado de productos", productViewModel.productList.value!!, databaseViewModel, context)
    }
}

@Composable
fun ProductListView(
    title: String,
    productList: List<ProductResponse>,
    databaseViewModel: ProductDBViewModel,
    context: Context
) {
    ProductList(title, productList, Icons.Filled.Add) { product: ProductResponse ->
        Toast.makeText(context, "Producto agregado a Favoritos", Toast.LENGTH_SHORT).show()
        databaseViewModel.insertOrUpdateFavoriteProduct(productResponseToProduct(product))
    }
}

