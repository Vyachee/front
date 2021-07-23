package com.greeenwald.wheresthetoilet.ui.auth

import com.greeenwald.wheresthetoilet.common.UserData

interface LoginContractView {
    fun getUserData(): UserData
    fun showLoading()
    fun hideLoading()
    fun goToRegister()
    fun clearFields()
    fun toggleButtonEnabled(state: Boolean)
    fun showMessage(message: String)
}