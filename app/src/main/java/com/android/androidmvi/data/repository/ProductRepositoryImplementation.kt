package com.android.androidmvi.data.repository

import com.android.androidmvi.core.Resource
import com.android.androidmvi.core.toResource
import com.android.androidmvi.data.remote.ProductApi
import com.android.androidmvi.domain.model.reponse.ProductResponse
import com.android.androidmvi.domain.remote.ProductRepository
import javax.inject.Inject

class ProductRepositoryImplementation @Inject constructor(private val productApi: ProductApi): ProductRepository {
    override suspend fun getProductList(): Resource<ProductResponse>? {
        return  productApi.getProducts()?.toResource()
    }
}