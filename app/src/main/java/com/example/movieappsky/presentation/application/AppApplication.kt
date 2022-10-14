package com.example.movieappsky.presentation.application

import android.app.Application
import com.example.movieappsky.data.database.DataBaseProvider

class AppApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        DataBaseProvider.initDatabase(applicationContext)
    }
}