package com.example.semen_zadorozhnyi.trymoxy

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter

@InjectViewState
class MainPresenter : MvpPresenter<MainView>() {

    init {
        viewState.showText("0")
    }

    fun onPlusPressed(current: String) {
        viewState.showText((current.toInt() + 1).toString())
    }

    fun onMinusPressed(current: String) {
        viewState.showText((current.toInt() - 1).toString())
    }
}
