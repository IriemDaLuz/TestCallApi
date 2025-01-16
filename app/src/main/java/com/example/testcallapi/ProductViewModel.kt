package com.example.testcallapi

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

import com.example.testcallapi.network.product.model.ProductRepository
import com.example.testcallapi.network.product.model.ProductResponse

class ProductViewModel {
    private val productListRepository = ProductRepository()

    private val _productList= MutableLiveData<List<ProductResponse>>(emptyList())
    val productList: LiveData<List<ProductResponse>> = _productList

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    fun getAllProducts(){
        viewModelScope.launch {
            _isLoading.value = true
            _productList.postValue(productListRepository.getAllProducts().productList())
            _isLoading.value = false
        }
    }
}