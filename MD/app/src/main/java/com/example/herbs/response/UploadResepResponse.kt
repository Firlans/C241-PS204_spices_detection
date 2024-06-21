package com.example.herbs.response

import com.google.gson.annotations.SerializedName

data class UploadResepResponse(
	@field:SerializedName("data")
	val data: Data,

	@field:SerializedName("message")
	val message: String,

	@field:SerializedName("status")
	val status: String
)

data class Data(
	@field:SerializedName("id_picture")
	val idPicture: String,

	@field:SerializedName("bahan")
	val bahan: List<String>,

	@field:SerializedName("author")
	val author: String,

	@field:SerializedName("langkah_pembuatan")
	val langkahPembuatan: List<String>,

	@field:SerializedName("name")
	val name: String,

	@field:SerializedName("description")
	val description: String,

	@field:SerializedName("id")
	val id: String,

	@field:SerializedName("asal_daerah")
	val asalDaerah: String
)
