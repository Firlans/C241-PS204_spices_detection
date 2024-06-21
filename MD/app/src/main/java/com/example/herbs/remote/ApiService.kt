package com.example.herbs.remote

import com.example.herbs.response.AuthResponse
import com.example.herbs.response.ResepResponse
import com.example.herbs.response.UploadResepResponse
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part
import retrofit2.http.Query

interface ApiService {
    @GET("all-recipes")
    fun getAllRecipes(): Call<ResepResponse>

    @GET("/recipes/name")
    fun getRecipesByName(@Query("name") name: String): Call<ResepResponse>

    @Multipart
    @POST("recipe-post")
    fun uploadRecipe(
        @Query("name") name: String,
        @Query("asalDaerah") region: String,
        @Query("bahanBahan") ingredients: String,
        @Query("author") author: String,
        @Query("description") description: String,
        @Query("langkahPembuatan") steps: String,
        @Part image: MultipartBody.Part
    ): Call<UploadResepResponse>

    @Multipart
    @POST("register")
    fun register(
        @Query("name") name: String,
        @Query("email") email: String,
        @Query("password") password: String,
        @Part avatar: MultipartBody.Part
    ): Call<AuthResponse>

    @POST("login")
    fun login(
        @Query("email") email: String,
        @Query("password") password: String
    ): Call<AuthResponse>
}