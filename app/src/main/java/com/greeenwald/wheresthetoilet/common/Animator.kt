package com.greeenwald.wheresthetoilet.common

import android.app.Activity
import android.content.Context
import android.os.Handler
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class Animator(val activity: Activity) {
    fun fadeIn(view: View) {
        activity.runOnUiThread {

            view.visibility = VISIBLE
            view.animate().alpha(1f).duration = 250
        }
    }

    fun fadeOut(view: View) {
        activity.runOnUiThread {

            view.animate().alpha(0f).setDuration(250).withEndAction {
                view.visibility = GONE
            }

        }

    }
}