package com.greeenwald.wheresthetoilet.ui.auth

import android.content.Context
import com.greeenwald.wheresthetoilet.common.UserData

interface LoginContractView {
    fun getUserData(): UserData
    fun showLoading()
    fun hideLoading()
    fun goToRegister()
    fun goMainScreen()
    fun clearFields()
    fun getContext(): Context
    fun toggleButtonEnabled(state: Boolean)
    fun showMessage(message: String)
}