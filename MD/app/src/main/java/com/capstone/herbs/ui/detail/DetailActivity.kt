package com.capstone.herbs.ui.detail

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.capstone.herbs.R
import com.capstone.herbs.databinding.ActivityDetailBinding
import com.capstone.herbs.databinding.ActivityMainBinding
import com.capstone.herbs.databinding.ActivityProfileBinding

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding

    companion object {
        const val TITLE = "judul"
        const val GAMBAR = "@drawable/miku.png"
        const val MANFAAT = "tidak ada"
        const val OLAHAN = "tidak tahu"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val gambar = intent.getStringExtra(GAMBAR)
        val manfaatId = intent.getIntExtra(MANFAAT, 0)
        val olahanId = intent.getIntExtra(OLAHAN, 0)
        val judul = intent.getStringExtra(TITLE)
        binding.title.text = judul
        if (gambar != null) {
            val resId = resources.getIdentifier(gambar, "drawable", packageName)
            if (resId != 0) {
                binding.imageView2.setImageResource(resId)
            }
        }
        if (manfaatId != 0) {
            binding.tvmanfaat.text = getString(manfaatId)
        }

        if (olahanId != 0) {
            binding.tvolahan.text = getString(olahanId)
        }
    }
}