package com.greeenwald.wheresthetoilet.ui.register

import com.greeenwald.wheresthetoilet.common.UserData

interface RegisterContractView {
    fun getUserData(): UserData
    fun showLoading()
    fun hideLoading()
    fun showMessage(message: String)
}