package com.example.testcallapi

import android.content.Context
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue

import androidx.compose.material3.Text
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.testcallapi.network.product.model.ProductResponse


@Composable
fun ProductListScreen(
    productViewModel: ProductViewModel,
    context: Context,
    innerPaddingValues: PaddingValues
    ){
    val isLoading:Boolean by productViewModel.isLoading.observeAsState(initial=true)
    if (isLoading){
        productViewModel.getAllProducts()
        LoadingScreen()
    }else{
        CompleteProductListScreen(productViewModel.productList.value!!,innerPaddingValues)
    }
}

@Composable
fun CompleteProductListScreen(
    productList: List<ProductResponse>,
    innerPaddingValues: PaddingValues
){
    LazyColumn (
        modifier = Modifier.fillMaxWidth().padding(innerPaddingValues),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        item {
            Text(
                modifier = Modifier.padding(top = 25.dp),
                text = "Lista de Productos",
                fontSize = TextUnit(8.0f, type = TextUnitType.Em),
                fontWeight = FontWeight.Bold
            )
        }

        if (productList.isEmpty()){
            item{
                Text(modifier=Modifier.padding(top=25.dp),
                    text="No hay productos",
                    fontSize= TextUnit(8.0f, type= TextUnitType.Em)
                )
            }
        } else{
            items(productList) { product ->
                Card(
                    colors = CardDefaults.cardColors(
                        containerColor = Color.LightGray
                    ),
                    modifier = Modifier.width(260.dp).padding(bottom = 10.dp)
                ) {
                    Text(
                        text = product.title,
                        fontSize = TextUnit(8.0f, TextUnitType.Em),
                        modifier = Modifier.weight(1f)
                    )

                    HorizontalDivider(
                        modifier = Modifier.padding(bottom = 10.dp),
                        thickness = 1.dp,
                        color = Color.Gray
                    )
                    Column(
                        modifier = Modifier.fillMaxSize().padding(start = 5.dp),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        AsyncImage(
                            modifier = Modifier.size(160.dp),
                            model = product.thumbnail,
                            coontentDescription = product.title
                        )
                    }
                }
            }
        }
    }
}

