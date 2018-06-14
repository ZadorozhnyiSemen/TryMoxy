package com.example.semen_zadorozhnyi.trymoxy.utils

import android.view.View

fun View.show(visible: Boolean) {
    visibility = if (visible) View.VISIBLE else View.GONE
}