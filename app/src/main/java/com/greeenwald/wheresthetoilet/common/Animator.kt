package com.greeenwald.wheresthetoilet.common

import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class Animator {
    fun fadeIn(view: View) {
        view.visibility = VISIBLE
        view.animate().alpha(1f).duration = 250
    }

    fun fadeOut(view: View) {
        view.animate().alpha(0f).setDuration(250).withEndAction {
            view.visibility = GONE
        }

    }
}