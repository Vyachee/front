package com.greeenwald.wheresthetoilet.ui.register

import android.service.autofill.UserData
import android.util.Log
import com.google.gson.Gson
import com.greeenwald.wheresthetoilet.common.ErrorDecoder
import com.greeenwald.wheresthetoilet.common.ErrorsData
import com.greeenwald.wheresthetoilet.ui.register.RegisterModel.OnRegisterCallback

class RegisterPresenter(val model: RegisterModel) {
    var view: RegisterContractView? = null

    fun makeRegister() {
        view?.showLoading()
        val userData = view?.getUserData()

        model.doRegister(userData, object : OnRegisterCallback {
            override fun registerRequestComplete(response: String) {

                Log.d("DEBUG", "Response: $response")

                view?.hideLoading()

                if(response == "") {
                    view?.showMessage("Регистрация успешна! Пройдите авторизацию")
                }   else {
                    val errorsData = Gson().fromJson(response, ErrorsData::class.java)
                    view?.showMessage(ErrorDecoder().getHumanMessage(errorsData.errorsData[0]))
                }
            }
        })
    }

    private fun validateEmail() {

    }

    fun attachView(view: RegisterContractView) {
        this.view = view
    }

    fun detachView() {
        this.view = null
    }

}