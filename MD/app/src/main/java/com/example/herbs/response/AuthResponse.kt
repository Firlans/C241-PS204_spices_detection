package com.example.herbs.response

import com.google.gson.annotations.SerializedName

data class AuthResponse(
	@SerializedName("status")
	val status: String,
	@SerializedName("message")
	val message: String,
	@SerializedName("token")
	val token: String
)


data class LoginResponse(
	@field:SerializedName("message")
	val message: String,

	@field:SerializedName("status")
	val status: String,

	@field:SerializedName("token")
	val token: String
)
