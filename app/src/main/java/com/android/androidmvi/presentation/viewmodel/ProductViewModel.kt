package com.android.androidmvi.presentation.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.androidmvi.core.Resource
import com.android.androidmvi.domain.model.reponse.ProductResponse
import com.android.androidmvi.domain.usecase.ProductListUseCase
import com.android.androidmvi.presentation.intent.ClickEvents
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductViewModel @Inject constructor(private val productUseCase: ProductListUseCase): ViewModel() {

    val result = MutableLiveData<Resource<ProductResponse>>()

    fun onEvent(events: ClickEvents){
        when(events){
            ClickEvents.ShowResult->{
                getProductList()
            }
        }
    }

    private fun getProductList(){
        viewModelScope.launch {
            result.value = Resource.Loading()
            result.value = productUseCase.invoke()
        }
    }
}