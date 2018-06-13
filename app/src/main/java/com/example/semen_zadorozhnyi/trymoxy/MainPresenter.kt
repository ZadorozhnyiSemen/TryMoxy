package com.example.semen_zadorozhnyi.trymoxy

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter

@InjectViewState
class MainPresenter : MvpPresenter<MainView>() {

    fun plus(current: String) {
        viewState.showText((current.toInt() + 1).toString())
    }

    fun minus(current: String) {
        viewState.showText((current.toInt() - 1).toString())
    }

    init {
        viewState.showText("0")
    }
}