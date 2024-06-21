package com.example.herbs.recipe

import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.herbs.databinding.ActivityDetailRecipeBinding

class DetailRecipeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailRecipeBinding
    private var selectedImageUri: Uri? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailRecipeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val recipeId = intent.getStringExtra("recipe_id")
        val recipeName = intent.getStringExtra("recipe_name")
        val recipeAuthor = intent.getStringExtra("recipe_author")
        val recipeAsal = intent.getStringExtra("recipe_asal")
        val recipeBahan = intent.getStringExtra("recipe_bahan")
        val recipeLangkah = intent.getStringExtra("recipe_langkah")
        val recipeDescription = intent.getStringExtra("recipe_description")
        val recipePicture = intent.getStringExtra("recipe_picture")

        binding.tvNamaResepValue.text = recipeName
        binding.tvAsalDaerahValue.text = recipeAsal
        binding.tvBahanValue.text = recipeBahan
        binding.tvPenulisValue.text = recipeAuthor
        binding.tvDeskripsiValue.text = recipeDescription
        binding.tvLangkahPembuatanValue.text = recipeLangkah
        Glide.with(this)
            .load(recipePicture)
            .fitCenter()
            .into(binding.imageResep)

        binding.btnBack.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }
    }
}
