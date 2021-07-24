package com.greeenwald.wheresthetoilet.ui.auth

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import android.widget.Toast
import com.greeenwald.wheresthetoilet.R
import com.greeenwald.wheresthetoilet.common.Animator
import com.greeenwald.wheresthetoilet.common.UserData
import com.greeenwald.wheresthetoilet.databinding.ActivityLoginBinding
import com.greeenwald.wheresthetoilet.ui.main.MapActivity

class LoginActivity : AppCompatActivity(), LoginContractView {

    lateinit var binding: ActivityLoginBinding
    lateinit var presenter: LoginPresenter

    lateinit var inputs: Array<EditText>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()
    }

    private fun init() {

        presenter = LoginPresenter(LoginModel())
        presenter.attachView(this)

        inputs = arrayOf(
            binding.etEmail,
            binding.etPassword
        )


        initListeners()
    }

    private fun initListeners() {
        for(input in inputs) {
            input.addTextChangedListener(object: TextWatcher {
                override fun beforeTextChanged(
                    s: CharSequence?,
                    start: Int,
                    count: Int,
                    after: Int
                ) {

                }

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

                }

                override fun afterTextChanged(s: Editable?) {
                    presenter.toggleButton()
                }

            })
        }

        binding.btnAuth.setOnClickListener {
            presenter.doLogin()
        }

        binding.tvGoBack.setOnClickListener {
            finish()
        }
    }

    override fun getUserData(): UserData {
        return UserData(
            email = binding.etEmail.text.toString(),
            password = binding.etPassword.text.toString()
        )
    }

    override fun showLoading() {
        Animator(this).fadeIn(binding.clLoader)
    }

    override fun hideLoading() {
        Animator(this).fadeOut(binding.clLoader)
    }

    override fun goToRegister() {
        finish()
    }

    override fun goMainScreen() {
        startActivity(Intent(this, MapActivity::class.java))
    }

    override fun clearFields() {
        for(input in inputs) {
            input.setText("")
        }
    }

    override fun getContext(): Context = this

    override fun toggleButtonEnabled(state: Boolean) {
        runOnUiThread {
            binding.btnAuth.isEnabled = state
        }
    }

    override fun showMessage(message: String) {
        runOnUiThread {
            Toast.makeText(this, message, Toast.LENGTH_LONG).show()
        }
    }
}