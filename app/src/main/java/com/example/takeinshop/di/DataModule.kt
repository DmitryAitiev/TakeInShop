package com.example.takeinshop.di

import android.app.Application
import com.example.takeinshop.data.AppDatabase
import com.example.takeinshop.data.ShopListDao
import com.example.takeinshop.data.ShopListRepositoryImpl
import com.example.takeinshop.domain.ShopListRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import javax.inject.Inject

@Module
interface DataModule {

    @ApplicationScope
    @Binds
    fun bindShopListRepository(impl: ShopListRepositoryImpl): ShopListRepository

    companion object {
        @Provides
        @ApplicationScope
        fun provideShopListDao(application: Application): ShopListDao{
            return AppDatabase.getInstance(application).shopListDao()
        }
    }
}