package com.android.androidmvi.di

import com.android.androidmvi.data.remote.ProductApi
import com.android.androidmvi.data.repository.ProductRepositoryImplementation
import com.android.androidmvi.domain.remote.ProductRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit

@InstallIn(SingletonComponent::class)
@Module
class ProductModule {

    @Provides
    fun productProducts(retrofit: Retrofit): ProductApi{
        return retrofit.create(ProductApi::class.java)
    }

    @Provides
    fun provideProductRepo(productApi: ProductApi): ProductRepository{
        return ProductRepositoryImplementation(productApi)
    }
}