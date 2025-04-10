package com.android.androidmvi.domain.usecase

import com.android.androidmvi.core.Resource
import com.android.androidmvi.domain.model.reponse.ProductResponse
import com.android.androidmvi.domain.remote.ProductRepository
import javax.inject.Inject

class ProductListUseCase @Inject constructor(private val repo: ProductRepository) {
    suspend fun invoke(): Resource<ProductResponse>?{
        return repo.getProductList()
    }
}