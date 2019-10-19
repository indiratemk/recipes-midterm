package com.example.recipesproject

import android.app.Application
import com.example.recipesproject.di.dbModule
import com.example.recipesproject.di.networkModule
import com.example.recipesproject.di.repoModule
import com.example.recipesproject.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class RecipesApp : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(applicationContext)
            modules(listOf(dbModule, networkModule, repoModule, viewModelModule))
        }
    }
}