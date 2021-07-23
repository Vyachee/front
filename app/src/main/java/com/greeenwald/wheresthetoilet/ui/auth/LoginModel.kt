package com.greeenwald.wheresthetoilet.ui.auth

import com.greeenwald.wheresthetoilet.common.Network
import com.greeenwald.wheresthetoilet.common.UserData
import okhttp3.Call
import okhttp3.Callback
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.Request
import okhttp3.RequestBody.Companion.toRequestBody
import okhttp3.Response
import org.json.JSONObject
import java.io.IOException

class LoginModel {

    fun doLogin(userData: UserData?, callback: LoginCallback) {

        val client = Network().getUnsafeOkHttpClient()
        val mediaTypeJson = "application/json; charset=utf-8".toMediaType()
        val json = JSONObject()
        json.put("login", userData?.email)
        json.put("password", userData?.password)
        val requestJson = json.toString()
        val requestBody = requestJson.toRequestBody(mediaTypeJson)
        val url = "${Network().baseUrl}Authorize/Login"

        val request = Request.Builder()
            .url(url)
            .post(requestBody)
            .build()

        client?.newCall(request)?.enqueue(object: Callback {
            override fun onFailure(call: Call, e: IOException) {
                callback.onFailed("Ошибка сервера")
            }

            override fun onResponse(call: Call, response: Response) {
                val message = response.body?.string()
                val cookie = response.headers.get("set-cookie")

                callback.onSuccess(message, cookie)
            }

        })
    }

    interface LoginCallback {
        fun onSuccess(message: String? = "", cookie: String? = "")
        fun onFailed(message: String)
    }

}