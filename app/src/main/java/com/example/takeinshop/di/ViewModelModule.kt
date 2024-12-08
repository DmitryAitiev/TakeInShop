package com.example.takeinshop.di

import androidx.lifecycle.ViewModel
import com.example.takeinshop.presentation.MainViewModel
import com.example.takeinshop.presentation.ShopItemViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import javax.inject.Inject

@Module
interface ViewModelModule {
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    @Binds
    fun bindMainViewModel(impl: MainViewModel): ViewModel

    @IntoMap
    @ViewModelKey(ShopItemViewModel::class)
    @Binds
    fun bindShopItemViewModel(item: ShopItemViewModel): ViewModel
}