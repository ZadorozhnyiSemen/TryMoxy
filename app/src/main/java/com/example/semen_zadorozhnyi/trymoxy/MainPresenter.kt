package com.example.semen_zadorozhnyi.trymoxy

import android.annotation.SuppressLint
import android.os.AsyncTask
import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import java.util.concurrent.TimeUnit

@InjectViewState
class MainPresenter : MvpPresenter<MainView>() {

    init {
        viewState.showText("0")
        startCounter()
    }

    fun onPlusPressed(current: String) {
        viewState.showText((current.toInt() + 1).toString())
    }

    fun onMinusPressed(current: String) {
        viewState.showText((current.toInt() - 1).toString())
    }

    fun onTryAgain() {
        startCounter()
    }

    @SuppressLint("StaticFieldLeak")
    private fun startCounter() {
        object : AsyncTask<Void, String, Void>() {
            override fun doInBackground(vararg params: Void?): Void? {
                for (i in 5 downTo 1) {
                    publishProgress(i.toString())
                    waitSecond()
                }
                return null
            }

            override fun onProgressUpdate(vararg values: String?) {
                values[0]?.let { viewState.setCounter(it) }
            }

            override fun onPostExecute(result: Void?) {
                viewState.hideCounter()
                viewState.showFinished()
                viewState.showTryAgain()
            }

            override fun onPreExecute() {
                viewState.showCounter()
                viewState.hideTryAgain()
            }

            private fun waitSecond() {
                try {
                    TimeUnit.SECONDS.sleep(1)
                } catch (e: Exception) {
                    println(e.stackTrace)
                }
            }
        }.execute()
    }
}
