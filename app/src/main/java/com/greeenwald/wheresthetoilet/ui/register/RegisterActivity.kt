package com.greeenwald.wheresthetoilet.ui.register

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.greeenwald.wheresthetoilet.common.Animator
import com.greeenwald.wheresthetoilet.common.UserData
import com.greeenwald.wheresthetoilet.databinding.ActivityMainBinding
import com.greeenwald.wheresthetoilet.ui.LicenceActivity
import com.greeenwald.wheresthetoilet.ui.auth.LoginActivity
import java.util.regex.Pattern

class RegisterActivity : AppCompatActivity(), RegisterContractView {

    lateinit var binding: ActivityMainBinding
    lateinit var presenter: RegisterPresenter
    lateinit var inputs: Array<EditText>

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


        inputs = arrayOf(
            binding.etEmail,
            binding.etPassword,
            binding.etPasswordRepeat,
            binding.etUsername,
        )


        initListeners()
    }

    private fun initListeners() {
        binding.btnReg.setOnClickListener {
            presenter.makeRegister()
        }

        for (input in inputs) {
            input.addTextChangedListener(object: TextWatcher {
                override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

                }

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

                }

                override fun afterTextChanged(s: Editable?) {
                    presenter.toggleButton()
                }

            })
        }

        binding.tvGoLogin.setOnClickListener {
            goToLogin()
        }

        binding.tvPersonalData.setOnClickListener {
            goLicence()
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

    override fun goLicence() {
        startActivity(Intent(this, LicenceActivity::class.java))
    }

    override fun goToLogin() {
        startActivity(Intent(this, LoginActivity::class.java))
    }

    override fun clearFields() {
        for(input in inputs) {
            input.setText("")
        }
    }

    override fun toggleButtonEnabled(state: Boolean) {
        runOnUiThread {
            binding.btnReg.isEnabled = state
        }
    }

    override fun showMessage(message: String) {

        // Temporary solution
        // I want cool window with custom view instead

        runOnUiThread {
            Toast.makeText(baseContext, message, Toast.LENGTH_LONG).show()
        }
    }


}