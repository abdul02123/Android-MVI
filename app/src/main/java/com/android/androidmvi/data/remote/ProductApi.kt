package com.android.androidmvi.data.remote

import com.android.androidmvi.domain.model.reponse.ProductResponse
import retrofit2.Response
import retrofit2.http.GET

interface ProductApi {
    @GET("products")
    suspend fun getProducts(): Response<ProductResponse>?
}