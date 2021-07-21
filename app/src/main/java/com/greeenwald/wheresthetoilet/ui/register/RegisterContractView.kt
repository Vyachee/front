package com.greeenwald.wheresthetoilet.ui.register

import com.greeenwald.wheresthetoilet.ui.common.UserData

interface RegisterContractView {
    fun getUserData(): UserData
    fun showLoading()
    fun hideLoading()
}