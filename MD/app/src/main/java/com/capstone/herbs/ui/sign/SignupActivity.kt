package com.capstone.herbs.ui.sign

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.capstone.herbs.R

class SignupActivity : AppCompatActivity() {

    private lateinit var etUsername: EditText
    private lateinit var etEmail: EditText
    private lateinit var etPassword: EditText
    private lateinit var etRepeatPassword: EditText
    private lateinit var btnSignUp: Button
    private lateinit var tvLogin: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        // Initialize views using findViewById
        etUsername = findViewById(R.id.etUsername)
        etEmail = findViewById(R.id.etEmail)
        etPassword = findViewById(R.id.etPassword)
        etRepeatPassword = findViewById(R.id.etRepeatPassword)
        btnSignUp = findViewById(R.id.btnSignUp)
        tvLogin = findViewById(R.id.tvLogin)

        // Set up button click listener
        btnSignUp.setOnClickListener {
            signUp()
        }

        // Set up login text click listener
        tvLogin.setOnClickListener {
            login()
        }
    }

    private fun signUp() {
        val username = etUsername.text.toString()
        val email = etEmail.text.toString()
        val password = etPassword.text.toString()
        val repeatPassword = etRepeatPassword.text.toString()

        if (username.isEmpty() || email.isEmpty() || password.isEmpty() || repeatPassword.isEmpty()) {
            Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show()
            return
        }

        if (password != repeatPassword) {
            Toast.makeText(this, "Passwords do not match", Toast.LENGTH_SHORT).show()
            return
        }

        // TODO: Add sign-up logic here

        Toast.makeText(this, "Sign-up successful", Toast.LENGTH_SHORT).show()
    }

    private fun login() {
        // TODO: Add logic to navigate to the login screen
        Toast.makeText(this, "Navigate to login screen", Toast.LENGTH_SHORT).show()
        val move = Intent(this@SignupActivity,LoginActivity::class.java)
        startActivity(move)
    }
}