package com.greeenwald.wheresthetoilet.ui.register

import android.util.Log
import com.google.gson.Gson
import com.greeenwald.wheresthetoilet.common.Network
import com.greeenwald.wheresthetoilet.common.UserData
import okhttp3.*
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.RequestBody.Companion.toRequestBody
import java.io.IOException

class RegisterModel {
    fun doRegister(userData: UserData?, callback: OnRegisterCallback) {

        val client = Network().getUnsafeOkHttpClient()
        val mediaTypeJson = "application/json; charset=utf-8".toMediaType()
        val requestJson = Gson().toJson(userData, UserData::class.java)
        val requestBody = requestJson.toRequestBody(mediaTypeJson)
        val url = "${Network().baseUrl}Authorize/Register"

        val request = Request.Builder()
            .url(url)
            .post(requestBody)
            .build()

        client?.newCall(request)?.enqueue(object: Callback {
            override fun onFailure(call: Call, e: IOException) {
                callback.registerFailed()
            }

            override fun onResponse(call: Call, response: Response) {
                response.body?.string()?.let { callback.registerRequestComplete(it) }
            }

        })
    }

    interface OnRegisterCallback {
        fun registerRequestComplete(response: String)
        fun registerFailed()
    }

}