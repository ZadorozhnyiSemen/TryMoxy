package com.example.semen_zadorozhnyi.trymoxy

import com.arellomobile.mvp.MvpView

interface MainView : MvpView {
    fun showText(someText: String)
}