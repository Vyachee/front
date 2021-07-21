package com.greeenwald.wheresthetoilet.ui.register

import com.greeenwald.wheresthetoilet.ui.common.UserData
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class RegisterModel {
    fun doRegister(userData: UserData?, callback: OnRegisterCallback) {
        // TODO

        // заглушка типо чето происходит, завтра допишу логику (работу с апишкой)
        GlobalScope.launch {
            android.os.SystemClock.sleep(3000)
            callback.registerComplete()
        }
    }

    interface OnRegisterCallback {
        fun registerComplete()
    }
}