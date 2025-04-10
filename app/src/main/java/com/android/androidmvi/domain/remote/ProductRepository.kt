package com.android.androidmvi.domain.remote

import com.android.androidmvi.core.Resource
import com.android.androidmvi.domain.model.reponse.ProductResponse

interface ProductRepository {
    suspend fun getProductList(): Resource<ProductResponse>?
}