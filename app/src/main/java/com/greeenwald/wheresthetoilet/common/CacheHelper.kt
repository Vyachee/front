package com.greeenwald.wheresthetoilet.common

import android.content.Context
import android.content.Context.MODE_PRIVATE

class CacheHelper(val context: Context) {

    val data = context.getSharedPreferences("user_data", MODE_PRIVATE)

    fun writeCookie(cookie: String) {
        val editor = data.edit()
        editor.putString("cookie", cookie)
        editor.apply()
        editor.commit()
    }

    fun getCookie(): String? {
        return data.getString("cookie", null);
    }


}