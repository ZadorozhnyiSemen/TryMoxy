package com.example.semen_zadorozhnyi.trymoxy

import android.os.Bundle
import android.support.v4.content.ContextCompat
import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.presenter.InjectPresenter
import com.example.semen_zadorozhnyi.trymoxy.utils.show
import kotlinx.android.synthetic.main.activity_main.counter
import kotlinx.android.synthetic.main.activity_main.greeting
import kotlinx.android.synthetic.main.activity_main.minus
import kotlinx.android.synthetic.main.activity_main.plus

class MainActivity : MvpAppCompatActivity(), MainView {

    @InjectPresenter lateinit var presenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        minus.setOnClickListener { presenter.onMinusPressed(greeting.text as String) }
        plus.setOnClickListener { presenter.onPlusPressed(greeting.text as String) }
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
    }
}
