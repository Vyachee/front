package com.greeenwald.wheresthetoilet.ui.register

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.greeenwald.wheresthetoilet.common.Animator
import com.greeenwald.wheresthetoilet.databinding.ActivityMainBinding
import com.greeenwald.wheresthetoilet.common.UserData

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
        val nickname = binding.etUsername.text.toString()
        val email = binding.etEmail.text.toString()
        val password = binding.etPassword.text.toString()
        val passwordRepeat = binding.etPasswordRepeat.text.toString()

        return UserData(
            nickname,
            email,
            password,
            passwordRepeat
        )
    }

    override fun showLoading() {
        Animator(this).fadeIn(binding.clLoader)
    }

    override fun hideLoading() {
        Animator(this).fadeOut(binding.clLoader)
    }

    override fun showMessage(message: String) {

        // Temporary solution
        // I want cool window with custom view instead

        runOnUiThread {
            Toast.makeText(baseContext, message, Toast.LENGTH_LONG).show()
        }
    }


}