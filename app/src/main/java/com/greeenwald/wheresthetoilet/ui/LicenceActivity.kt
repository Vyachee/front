package com.greeenwald.wheresthetoilet.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.greeenwald.wheresthetoilet.R

class LicenceActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_licence)
    }

    fun back(view: View) {
        finish()
    }
}