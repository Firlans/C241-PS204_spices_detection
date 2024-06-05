package com.capstone.herbs.ui.password

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.capstone.herbs.R
import com.capstone.herbs.databinding.ActivityForgotPasswordBinding
import com.capstone.herbs.databinding.ActivityProfileBinding
import com.capstone.herbs.ui.sign.LoginActivity

class ForgotPassword : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityForgotPasswordBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityForgotPasswordBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tvSignIn.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        val move = Intent(this@ForgotPassword,LoginActivity::class.java)
        startActivity(move)
    }
}