package com.example.takeinshop.presentation

import android.app.Application
import com.example.takeinshop.di.DaggerApplicationComponent

class TISApp: Application() {

    val component by lazy {
        DaggerApplicationComponent.factory()
            .create(this)
    }
}