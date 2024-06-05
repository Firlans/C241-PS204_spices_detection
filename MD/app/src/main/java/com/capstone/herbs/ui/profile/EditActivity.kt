package com.capstone.herbs.ui.profile

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.capstone.herbs.databinding.ActivityEditBinding

class EditActivity : AppCompatActivity() {

    private lateinit var binding: ActivityEditBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.ivCameraIcon.setOnClickListener {
        }

        binding.ivProfilePicture.setOnClickListener {
        }


    }
}
