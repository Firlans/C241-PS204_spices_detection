package com.capstone.herbs.ui.splash

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.capstone.herbs.R
import com.capstone.herbs.ui.main.MainActivity
import com.capstone.herbs.ui.password.ForgotPassword
import com.capstone.herbs.ui.sign.LoginActivity
import com.capstone.herbs.ui.sign.SignupActivity

class WelcomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        // Initialize the views
        val imageView = findViewById<ImageView>(R.id.imageView)
        val titleText = findViewById<TextView>(R.id.title_text)
        val subtitleText = findViewById<TextView>(R.id.subtitle_text)
        val loginButton = findViewById<Button>(R.id.login_button)
        val signupButton = findViewById<Button>(R.id.signup_button)
        val forgetPasswordText = findViewById<TextView>(R.id.forget_password_text)

        // Set click listeners for the buttons
        loginButton.setOnClickListener {
            // Handle login button click
            val login = Intent(this@WelcomeActivity, LoginActivity::class.java)
            startActivity(login)
        }

        signupButton.setOnClickListener {
            // Handle signup button click
            val register = Intent(this@WelcomeActivity,SignupActivity::class.java)
            startActivity(register)
        }

        forgetPasswordText.setOnClickListener {
            // Handle forget password text click
//            val resetpass = Intent(this@WelcomeActivity,ForgotPassword::class.java)
            val resetpass = Intent(this@WelcomeActivity,MainActivity::class.java)
            startActivity(resetpass)
        }
        val succeslogin = false
        if (succeslogin){
            val mainIntent = Intent(this@WelcomeActivity, MainActivity::class.java)
            startActivity(mainIntent)
            finish()
        }
    }
}
