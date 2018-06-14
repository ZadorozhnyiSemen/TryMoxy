package com.example.semen_zadorozhnyi.trymoxy

import android.app.Application
import ru.terrakok.cicerone.Cicerone
import ru.terrakok.cicerone.Router

class MainApplication : Application() {

    private lateinit var cicerone: Cicerone<Router>

    fun getNavigationHolder() = cicerone.navigatorHolder

    override fun onCreate() {
        super.onCreate()
        INSTANCE = this

        initCicerone()
    }

    private fun initCicerone() {
        cicerone = Cicerone.create()
    }

    companion object {
        lateinit var INSTANCE: MainApplication
    }
}