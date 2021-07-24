package com.greeenwald.wheresthetoilet.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.greeenwald.wheresthetoilet.R
import com.greeenwald.wheresthetoilet.common.CacheHelper
import com.greeenwald.wheresthetoilet.ui.main.MapActivity
import com.greeenwald.wheresthetoilet.ui.register.RegisterActivity

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        init()
    }

    private fun init() {

        var intent = Intent(this, RegisterActivity::class.java)

        if(CacheHelper(this).getCookie() != null) {
            intent = Intent(this, MapActivity::class.java)
        }

        startActivity(intent)
        finish()

    }
}