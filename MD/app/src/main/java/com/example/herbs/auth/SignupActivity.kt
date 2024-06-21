package com.example.herbs.auth

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.text.TextUtils
import android.util.Patterns
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.herbs.databinding.ActivitySignupBinding
import com.example.herbs.remote.ApiClient
import com.example.herbs.response.AuthResponse
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.File

class SignupActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignupBinding
    private var selectedImageUri: Uri? = null
    companion object {
        private const val PICK_IMAGE_REQUEST = 1
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.ivProfilePicture.setOnClickListener {
            // Open gallery to select an image
            val intent = Intent(Intent.ACTION_PICK)
            intent.type = "image/*"
            startActivityForResult(intent, PICK_IMAGE_REQUEST)
        }

        binding.btnSignUp.setOnClickListener {
            if (validateInput()) {
                registerUser()
             }
        }

        binding.btnBack.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }

        binding.tvLogin.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null) {
            // Get the Uri of the selected image
            selectedImageUri = data.data
            // Set the image in ImageView
            binding.ivProfilePicture.setImageURI(selectedImageUri)
        }
    }
    private fun validateInput(): Boolean {
        val username = binding.etUsername.text.toString().trim()
        val email = binding.etEmail.text.toString().trim()
        val password = binding.etPassword.text.toString().trim()
        val confirmPassword = binding.etRepeatPassword.text.toString().trim()

        if (TextUtils.isEmpty(username)) {
            binding.etUsername.error = "Username is required"
            binding.etUsername.requestFocus()
            return false
        }

        if (TextUtils.isEmpty(email)) {
            binding.etEmail.error = "Email is required"
            binding.etEmail.requestFocus()
            return false
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            binding.etEmail.error = "Enter a valid email"
            binding.etEmail.requestFocus()
            return false
        }

        if (TextUtils.isEmpty(password)) {
            binding.etPassword.error = "Password is required"
            binding.etPassword.requestFocus()
            return false
        }

        if (password.length < 6) {
            binding.etPassword.error = "Password must be at least 6 characters"
            binding.etPassword.requestFocus()
            return false
        }

        if (TextUtils.isEmpty(confirmPassword)) {
            binding.etRepeatPassword.error = "Confirm your password"
            binding.etRepeatPassword.requestFocus()
            return false
        }

        if (password != confirmPassword) {
            binding.etRepeatPassword.error = "Passwords do not match"
            binding.etRepeatPassword.requestFocus()
            return false
        }

        if (selectedImageUri == null) {
            Toast.makeText(this, "Please select a profile picture", Toast.LENGTH_SHORT).show()
            return false
        }

        return true
    }
    private fun registerUser() {
        // Check if selectedImageUri is null
        if (selectedImageUri == null) {
            Toast.makeText(this, "Please select a profile picture", Toast.LENGTH_SHORT).show()
            return
        }
        val filePath = selectedImageUri?.let { uri ->
            val cursor = contentResolver.query(uri, null, null, null, null)
            cursor?.use {
                it.moveToFirst()
                val columnIndex = it.getColumnIndex("_data")
                it.getString(columnIndex)
            }
        }

        val file = File(filePath)
        val requestFile = RequestBody.create("image/*".toMediaTypeOrNull(), file)
        val avatar = MultipartBody.Part.createFormData("avatar", file.name, requestFile)

        val name = binding.etUsername.text.toString().trim()
        val email = binding.etEmail.text.toString().trim()
        val password = binding.etPassword.text.toString().trim()

        val call = ApiClient.apiService.register(name, email, password, avatar)
        call.enqueue(object : Callback<AuthResponse> {
            override fun onResponse(call: Call<AuthResponse>, response: Response<AuthResponse>) {
                if (response.isSuccessful && response.body()?.status == "success") {
                    showSuccessPopup()
                } else {
                    Toast.makeText(this@SignupActivity, "Registration failed: ${response.message()}", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<AuthResponse>, t: Throwable) {
                Toast.makeText(this@SignupActivity, "Network error: ", Toast.LENGTH_LONG).show()
            }
        })
    }

    private fun showSuccessPopup() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Registration Successful")
        builder.setMessage("Please check your email to verify your address.")
        builder.setPositiveButton("Open Gmail App") { dialog, _ ->
            openEmailClient()
            dialog.dismiss()
        }
        builder.setNegativeButton("Cancel") { dialog, _ ->
            dialog.dismiss()
        }
        builder.create().show()
    }
    private fun openEmailClient() {
        val intent = Intent(Intent.ACTION_MAIN).apply {
            addCategory(Intent.CATEGORY_APP_EMAIL)
            setPackage("com.google.android.gm") // Specify Gmail package
            flags = Intent.FLAG_ACTIVITY_NEW_TASK
        }

        try {
            startActivity(intent)
        } catch (e: ActivityNotFoundException) {
            Toast.makeText(this, "Gmail app not found.", Toast.LENGTH_SHORT).show()
            // Optionally, prompt the user to install Gmail
        }
    }


}