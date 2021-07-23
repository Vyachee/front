package com.greeenwald.wheresthetoilet.ui.register

import android.service.autofill.UserData
import android.util.Log
import android.util.Patterns
import com.google.gson.Gson
import com.greeenwald.wheresthetoilet.common.ErrorDecoder
import com.greeenwald.wheresthetoilet.common.ErrorsData
import com.greeenwald.wheresthetoilet.ui.register.RegisterModel.OnRegisterCallback

class RegisterPresenter(val model: RegisterModel) {
    var view: RegisterContractView? = null

    fun makeRegister() {
        val userData = view?.getUserData()
        if(
            userData?.email == "" ||
            !Patterns.EMAIL_ADDRESS.matcher(userData?.email).matches() ||
            userData?.nickname == "" ||
            userData?.password == "" ||
            userData?.password_repeat == ""
        ) {
            view?.showMessage("Проверьте все поля!")
            return
        }

        view?.showLoading()

        model.doRegister(userData, object : OnRegisterCallback {
            override fun registerRequestComplete(response: String) {

                Log.d("DEBUG", "Response: $response")

                view?.hideLoading()

                if(response == "") {
                    view?.showMessage("Регистрация успешна! Пройдите авторизацию.")
                    view?.clearFields()
                    view?.goToLogin()
                }   else {
                    val errorsData = Gson().fromJson(response, ErrorsData::class.java)
                    view?.showMessage(ErrorDecoder().getHumanMessage(errorsData.errorsData[0]))
                }
            }

            override fun registerFailed() {
                view?.showMessage("Ошибка сервера. Попробуйте позже.")
                view?.hideLoading()
            }
        })
    }

    fun toggleButton() {
        val userData = view?.getUserData()
        if(
            userData?.email == "" ||
            !Patterns.EMAIL_ADDRESS.matcher(userData?.email).matches() ||
            userData?.nickname == "" ||
            userData?.password == "" ||
            userData?.password_repeat == "" ||
            userData?.password_repeat != userData?.password
        ) {
            view?.toggleButtonEnabled(false)
        }    else {
            view?.toggleButtonEnabled(true)
        }
    }

    fun attachView(view: RegisterContractView) {
        this.view = view
    }

    fun detachView() {
        this.view = null
    }

}