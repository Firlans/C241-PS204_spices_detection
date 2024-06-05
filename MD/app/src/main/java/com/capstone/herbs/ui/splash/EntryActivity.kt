package com.capstone.herbs.ui.splash

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.capstone.herbs.R
//done
class EntryActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_entry)

        val buttonGetStarted = findViewById<Button>(R.id.button_get_started)

        // Set a click listener on the button
        buttonGetStarted.setOnClickListener(this)
    }

    override fun onClick(v: View?) {

        val moveIntent = Intent(this@EntryActivity, WelcomeActivity::class.java)
        startActivity(moveIntent)
    }
}

