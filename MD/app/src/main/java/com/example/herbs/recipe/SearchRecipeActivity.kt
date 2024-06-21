package com.example.herbs.recipe

import android.content.Intent
import android.os.Bundle
import android.widget.SearchView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.herbs.databinding.ActivitySearchRecipeBinding
import com.example.herbs.remote.ApiClient
import com.example.herbs.response.DataItem
import com.example.herbs.response.ResepResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class SearchRecipeActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySearchRecipeBinding
    private lateinit var adapter: RVRecipeAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySearchRecipeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = RVRecipeAdapter(this@SearchRecipeActivity, emptyList())
        binding.rvitemSpice.adapter = adapter
        binding.rvitemSpice.layoutManager = LinearLayoutManager(this)
        binding.rvitemSpice.setHasFixedSize(true)
        binding.btnAddRecipe.setOnClickListener {
            val intent = Intent(this, AddRecipeActivity::class.java)
            startActivity(intent)
        }
        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                newText?.let {
                    if (it.isNotEmpty()) {
                        searchRecipeByName(it)
                    } else {
                        remoteGetRecipe()
                    }
                }
                return true
            }
        })
        remoteGetRecipe()
    }
    private fun searchRecipeByName(query: String) {
        ApiClient.apiService.getRecipesByName(query).enqueue(object : Callback<ResepResponse> {
            override fun onResponse(call: Call<ResepResponse>, response: Response<ResepResponse>) {
                if (response.isSuccessful) {
                    val data = response.body()?.data ?: emptyList()
                    setDataToAdapter(data)
                }
            }

            override fun onFailure(call: Call<ResepResponse>, t: Throwable) {
               //
            }
        })
    }

    private fun remoteGetRecipe() {
        ApiClient.apiService.getAllRecipes().enqueue(object : Callback<ResepResponse> {
            override fun onResponse(call: Call<ResepResponse>, response: Response<ResepResponse>) {
                if (response.isSuccessful) {
                    val data = response.body()?.data ?: emptyList()
                    setDataToAdapter(data)
                }
            }

            override fun onFailure(call: Call<ResepResponse>, t: Throwable) {
               //
            }
        })
    }

    private fun setDataToAdapter(data: List<DataItem>) {
        adapter.setData(data)
    }
}

