package com.example.herbs

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.herbs.auth.LoginActivity
import com.example.herbs.databinding.ActivityMainBinding
import com.example.herbs.main.HomeFragment
import com.example.herbs.ml.ScanFragment
import com.example.herbs.recipe.AddRecipeFragment
import com.example.herbs.remote.SessionManager

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var sessionManager: SessionManager
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sessionManager = SessionManager(this)
        sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE)

        if (sessionManager.fetchAuthToken().isNullOrEmpty() || !isLoggedIn()) {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        } else {
            setCurrentFragment(HomeFragment())
        }

        binding.bottomNavigationView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.home -> setCurrentFragment(HomeFragment())
                R.id.scan -> setCurrentFragment(ScanFragment())
                R.id.add_recipe -> setCurrentFragment(AddRecipeFragment())
            }
            true
        }
    }

    private fun isLoggedIn(): Boolean {
        return sharedPreferences.getBoolean("isLoggedIn", false)
    }

    private fun setCurrentFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.flFragment, fragment)
            commit()
        }
    }
}
