package com.android.androidmvi.domain.model.reponse

import java.io.Serializable

data class ProductResponse(
    val limit: Int?,
    val products: ArrayList<Product>,
    val skip: Int?,
    val total: Int?
) : Serializable