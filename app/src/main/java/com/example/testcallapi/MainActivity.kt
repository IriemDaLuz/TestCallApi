package com.example.testcallapi

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.testcallapi.ui.theme.TestCallApiTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TestCallApiTheme(dynamicColor = false) {
                val productViewModel: ProductViewModel = viewModel()
                val context = LocalContext.current
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ProductListScreen(productViewModel, context,innerPadding)
                }
            }
        }
    }
}
