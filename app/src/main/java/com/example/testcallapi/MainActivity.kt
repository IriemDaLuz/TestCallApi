package org.iesharia.testcallapi


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.room.Room
import androidx.compose.ui.platform.LocalContext

import com.example.testcallapi.FavouriteScreen
import com.example.testcallapi.ProductListScreen
import com.example.testcallapi.data.ProductViewModel
import com.example.testcallapi.SearchScreen
import com.example.testcallapi.db.ProductDatabase
import com.example.testcallapi.ui.theme.TestCallApiTheme

class MainActivity : ComponentActivity() {
    val db by lazy {
        Room.databaseBuilder(
            context = applicationContext,
            klass = ProductDatabase::class.java,
            name = "product.db"
        ).build()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TestCallApiTheme(dynamicColor = false) {
                val navController: NavHostController = rememberNavController()
                Scaffold(
                    bottomBar = {
                        BottomAppBar(
                            actions={ BottomBarItems(navController)
                            }
                   )
                }
             ) { innerPadding ->
                    val productViewModel: ProductViewModel = viewModel()
                    val context = LocalContext.current
                    NavHost(
                        navController = navController,
                        startDestination = "product_list_screen",
                        modifier = Modifier.fillMaxSize().padding(innerPadding)
                    ) {
                        composable(route = "product_list_screen") {
                            ProductListScreen(productViewModel, context, innerPadding)
                        }
                        composable(route = "favorite_list_screen") {
                            FavouriteScreen(productViewModel, context, innerPadding)
                        }
                        composable(route = "search_screen") {
                            SearchScreen(productViewModel, context, innerPadding)
                        }
                    }
                }
            }
        }
    }
@Composable
fun BottomBarItems(navController: NavController) {
    Row (
        modifier=Modifier.fillMaxWidth(),
        verticalAlignment=Alignment.CenterVertically,
        horizontalArrangement=Arrangement.Center
    ){
        IconButton(
            onClick = {navController.navigate("product_list_screen")}
        ) {
            Icon(
                modifier=Modifier.fillMaxSize(),
                imageVector = Icons.Filled.Home,
                contentDescription = "Home"

            )
        }
        IconButton(
            onClick = {navController.navigate("product_list_screen")}
        ) {
            Icon(
                modifier=Modifier.fillMaxSize(),
                imageVector = Icons.Filled.Favorite,
                contentDescription = "Home"

            )
        }
        IconButton(
            onClick = {navController.navigate("product_list_screen")}
        ) {
            Icon(
                modifier=Modifier.fillMaxSize(),
                imageVector = Icons.Filled.Search,
                contentDescription = "Home"

            )
        }
    }
    }
}

