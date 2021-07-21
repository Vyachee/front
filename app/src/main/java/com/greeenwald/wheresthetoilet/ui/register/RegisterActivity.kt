package com.greeenwald.wheresthetoilet.ui.register

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.greeenwald.wheresthetoilet.R
import com.greeenwald.wheresthetoilet.common.Animator
import com.greeenwald.wheresthetoilet.databinding.ActivityMainBinding
import com.greeenwald.wheresthetoilet.ui.common.UserData

class RegisterActivity : AppCompatActivity(), RegisterContractView {

    lateinit var binding: ActivityMainBinding
    lateinit var presenter: RegisterPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()
    }

    private fun init() {

        val model = RegisterModel()
        presenter = RegisterPresenter(model)
        presenter.attachView(this)

        initListeners()
    }

    private fun initListeners() {
        binding.btnReg.setOnClickListener {
            presenter.makeRegister()
        }
    }

    override fun getUserData(): UserData {
        val username = binding.etUsername.text.toString()
        val email = binding.etEmail.text.toString()
        val password = binding.etPassword.text.toString()
        val passwordRepeat = binding.etPasswordRepeat.text.toString()

        return UserData(
            username,
            email,
            password,
            passwordRepeat
        )
    }

    override fun showLoading() {
        Animator().fadeIn(binding.clLoader)
    }

    override fun hideLoading() {
        Animator().fadeOut(binding.clLoader)
    }


}