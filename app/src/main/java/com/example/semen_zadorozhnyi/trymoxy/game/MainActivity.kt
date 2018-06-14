package com.example.semen_zadorozhnyi.trymoxy.game

import android.os.Bundle
import android.support.v4.content.ContextCompat
import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.presenter.InjectPresenter
import com.example.semen_zadorozhnyi.trymoxy.R
import com.example.semen_zadorozhnyi.trymoxy.utils.show
import kotlinx.android.synthetic.main.activity_main.counter
import kotlinx.android.synthetic.main.activity_main.greeting
import kotlinx.android.synthetic.main.activity_main.plus
import kotlinx.android.synthetic.main.activity_main.try_again_button as tryAgain

class MainActivity : MvpAppCompatActivity(), MainView {

    @InjectPresenter
    lateinit var presenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        plus.setOnClickListener { presenter.onPlusPressed(greeting.text as String) }
        tryAgain.setOnClickListener { presenter.onTryAgain() }
    }

    override fun showText(someText: String) {
        greeting.text = someText
    }

    override fun showCounter() {
        counter.show(true)
    }

    override fun hideCounter() {
        counter.show(false)
    }

    override fun setCounter(value: String) {
        counter.text = value
    }

    override fun showFinished() {
        counter.setTextColor(ContextCompat.getColor(this, R.color.done))
        counter.show(true)
        counter.text = getString(R.string.finished)
        plus.isEnabled = false
        plus.setBackgroundColor(ContextCompat.getColor(this, R.color.plus_disabled))
    }

    override fun hideTryAgain() {
        counter.setTextColor(ContextCompat.getColor(this, R.color.colorWhite))
        plus.setBackgroundColor(ContextCompat.getColor(this, R.color.plus_enabled))
        tryAgain.show(false)
        plus.isEnabled = true
    }

    override fun showTryAgain() {
        tryAgain.show(true)
    }
}
