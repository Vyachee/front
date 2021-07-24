package com.greeenwald.wheresthetoilet.ui.auth

import android.util.Log
import android.util.Patterns
import com.google.gson.Gson
import com.greeenwald.wheresthetoilet.common.CacheHelper
import com.greeenwald.wheresthetoilet.common.ErrorDecoder
import com.greeenwald.wheresthetoilet.common.ErrorsData

class LoginPresenter(val model: LoginModel) {
    var view: LoginContractView? = null

    fun toggleButton() {
        view?.toggleButtonEnabled(isUserDataValid())
    }

    private fun isUserDataValid(): Boolean {
        val userData = view?.getUserData()
        if(
            userData?.password == ""||
            userData?.email == "" ||
            !Patterns.EMAIL_ADDRESS.matcher(userData?.email).matches()
        ) {
            return false
        }
        return true
    }

    fun doLogin() {
        if(!isUserDataValid()) return

        view?.showLoading()
        model.doLogin(userData = view?.getUserData(), object: LoginModel.LoginCallback {
            override fun onSuccess(message: String?, cookie: String?) {

                view?.hideLoading()
                if(!message.isNullOrEmpty()) {
                    val errorsData = Gson().fromJson(message, ErrorsData::class.java)
                    view?.showMessage(ErrorDecoder().getHumanMessage(errorsData.errorsData[0]))

                }   else {
                    if(cookie == null) {
                        view?.showMessage("Произошла неизвестная ошибка")
                    }   else {
                        view?.clearFields()
                        view?.showMessage("Успешная авторизация!")

                        view?.getContext()?.let { CacheHelper(it).writeCookie(cookie) }
                        view?.goMainScreen()

                    }
                }
            }

            override fun onFailed(message: String) {
                view?.hideLoading()
                view?.showMessage(message)
            }

        })

    }

    fun attachView(view: LoginContractView) {
        this.view = view
    }

    fun detachView() {
        this.view = null
    }

}