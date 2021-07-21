package com.greeenwald.wheresthetoilet.ui.register

import android.service.autofill.UserData
import com.greeenwald.wheresthetoilet.ui.register.RegisterModel.OnRegisterCallback

class RegisterPresenter(val model: RegisterModel) {
    var view: RegisterContractView? = null

    fun makeRegister() {
        view?.showLoading()
        val userData = view?.getUserData()

        model.doRegister(userData, object : OnRegisterCallback {
            override fun registerComplete() {

                view?.hideLoading()
            }
        })
        // todo call model
    }

    fun attachView(view: RegisterContractView) {
        this.view = view
    }

    fun detachView() {
        this.view = null
    }

}