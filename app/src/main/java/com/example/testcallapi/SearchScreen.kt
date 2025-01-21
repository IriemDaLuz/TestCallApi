package com.example.testcallapi

import android.content.Context
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.example.testcallapi.data.ProductViewModel

@Composable
fun SearchScreen(
    productViewModel: ProductViewModel,
    context: Context,
    innerPaddingValues: PaddingValues
){
    Text(text = "Busca productos")

}