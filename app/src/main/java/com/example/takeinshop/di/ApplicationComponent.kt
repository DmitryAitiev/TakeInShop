package com.example.takeinshop.di

import android.app.Application
import com.example.takeinshop.presentation.MainActivity
import com.example.takeinshop.presentation.ShopItemActivity
import com.example.takeinshop.presentation.ShopItemFragment
import dagger.BindsInstance
import dagger.Component

@ApplicationScope
@Component(modules = [DataModule::class, ViewModelModule::class])
interface ApplicationComponent {

    fun inject(activity: MainActivity)

    fun inject(activity: ShopItemActivity)

    fun inject(fragment: ShopItemFragment)

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance application: Application
        ): ApplicationComponent
    }
}