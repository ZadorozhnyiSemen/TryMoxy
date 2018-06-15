package com.example.semen_zadorozhnyi.trymoxy.game

import android.os.AsyncTask
import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import java.lang.ref.WeakReference
import java.util.concurrent.TimeUnit

@InjectViewState
class MainPresenter : MvpPresenter<MainView>() {

    init {
        viewState.showText(DEFAULT_SCORE)
        createCountTask(viewState).execute()
    }

    fun onPlusPressed(current: String) {
        viewState.showText((current.toInt() + 1).toString())
    }

    fun onTryAgain() {
        viewState.showText(DEFAULT_SCORE)
        createCountTask(viewState).execute()
    }

    private fun createCountTask(viewState: MainView) = CountTask(viewState)

    class CountTask(viewState: MainView) : AsyncTask<Void, String, Void>() {

        private var weakViewState: WeakReference<MainView> = WeakReference(viewState)

        override fun doInBackground(vararg params: Void?): Void? {
            for (i in 5 downTo 1) {
                publishProgress(i.toString())
                waitSecond()
            }
            return null
        }

        override fun onProgressUpdate(vararg values: String?) {
            values[0]?.let { weakViewState.get()?.setCounter(it) }
        }

        override fun onPostExecute(result: Void?) {
            weakViewState.get()?.hideCounter()
            weakViewState.get()?.showFinished()
            weakViewState.get()?.showTryAgain()
        }

        override fun onPreExecute() {
            weakViewState.get()?.showCounter()
            weakViewState.get()?.hideTryAgain()
        }

        private fun waitSecond() {
            try {
                TimeUnit.SECONDS.sleep(1)
            } catch (e: Exception) {
                println(e.stackTrace)
            }
        }
    }

    companion object {
        private const val DEFAULT_SCORE = "0"
    }
}
