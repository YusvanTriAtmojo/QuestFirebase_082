package com.example.application10

import android.app.Application
import com.example.application10.di.AppContainer
import com.example.application10.di.MahasiswaContainer

class MahasiswaApplications: Application() {
    lateinit var container: AppContainer
    override fun onCreate() {
        super.onCreate()
        container = MahasiswaContainer()
    }
}