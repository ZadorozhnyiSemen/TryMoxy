package com.example.semen_zadorozhnyi.trymoxy

import android.os.Bundle
import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.presenter.InjectPresenter
import kotlinx.android.synthetic.main.activity_main.greeting
import kotlinx.android.synthetic.main.activity_main.minus
import kotlinx.android.synthetic.main.activity_main.plus

class MainActivity : MvpAppCompatActivity(), MainView {

    @InjectPresenter lateinit var presenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        minus.setOnClickListener { presenter.minus(greeting.text as String) }
        plus.setOnClickListener { presenter.plus(greeting.text as String) }
    }

    override fun showText(someText: String) {
        greeting.text = someText
    }
}
