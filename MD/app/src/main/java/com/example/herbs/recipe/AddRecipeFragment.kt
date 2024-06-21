package com.example.herbs.recipe

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.herbs.databinding.FragmentAddRecipeBinding
import com.example.herbs.remote.ApiClient
import com.example.herbs.response.UploadResepResponse
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.File

class AddRecipeFragment : Fragment() {

    private var _binding: FragmentAddRecipeBinding? = null
    private val binding get() = _binding!!
    private lateinit var galleryLauncher: ActivityResultLauncher<Intent>
    private var selectedImageUri: Uri? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAddRecipeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        galleryLauncher =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
                onGalleryActivityResult(result)
            }

        binding.btnAddPhoto.setOnClickListener {
            val galleryIntent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI).apply {
                type = "image/*"
                putExtra(Intent.EXTRA_MIME_TYPES, arrayOf("image/jpeg", "image/png", "image/gif")) // You can add more image types if needed
            }
            galleryLauncher.launch(galleryIntent)
        }

        binding.btnSaveRecipe.setOnClickListener {
            val name = binding.etNamaResep.text.toString().trim()
            val region = binding.etAsalDaerah.text.toString().trim()
            val ingredients = binding.etBahan.text.toString().trim()
            val author = binding.etPenulis.text.toString().trim()
            val description = binding.etDeskripsi.text.toString().trim()
            val steps = binding.etLangkahPembuatan.text.toString().trim()

            // Check if all EditText fields are not empty and an image is selected
            if (name.isEmpty() || region.isEmpty() || ingredients.isEmpty() ||
                author.isEmpty() || description.isEmpty() || steps.isEmpty() ||
                selectedImageUri == null
            ) {
                Toast.makeText(context, "Please fill in all fields and select an image", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            uploadRecipe(name, region, ingredients, author, description, steps, selectedImageUri!!)
        }
    }

    private fun uploadRecipe(
        name: String, region: String, ingredients: String, author: String,
        description: String, steps: String, imageUri: Uri
    ) {
        val apiService = ApiClient.apiService

        val filePathColumn = arrayOf(MediaStore.Images.Media.DATA)
        val cursor = requireActivity().contentResolver.query(imageUri, filePathColumn, null, null, null)
        cursor?.moveToFirst()

        val columnIndex = cursor?.getColumnIndex(filePathColumn[0])
        val picturePath = cursor?.getString(columnIndex!!)
        cursor?.close()

        if (picturePath != null) {
            val file = File(picturePath)

            // Ensure the selected file is an image
            val mimeType = requireActivity().contentResolver.getType(imageUri)
            if (mimeType != null && mimeType.startsWith("image/")) {
                val requestFile = RequestBody.create(mimeType.toMediaTypeOrNull(), file)
                val body = MultipartBody.Part.createFormData("image", file.name, requestFile)

                // Send request to API
                apiService.uploadRecipe(
                    name,
                    region,
                    ingredients,
                    author,
                    description,
                    steps,
                    body
                ).enqueue(object : Callback<UploadResepResponse> {
                    override fun onResponse(call: Call<UploadResepResponse>, response: Response<UploadResepResponse>) {
                        if (response.isSuccessful) {
                            Toast.makeText(context, "Recipe uploaded successfully!", Toast.LENGTH_SHORT).show()

                            // Clear input fields and reset selected image URI
                            binding.etNamaResep.text.clear()
                            binding.etAsalDaerah.text.clear()
                            binding.etBahan.text.clear()
                            binding.etPenulis.text.clear()
                            binding.etDeskripsi.text.clear()
                            binding.etLangkahPembuatan.text.clear()
                            selectedImageUri = null

                            // Redirect to SearchRecipeActivity
                            val intent = Intent(activity, SearchRecipeActivity::class.java)
                            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP
                            startActivity(intent)
                        } else {
                            Toast.makeText(context, "Failed to upload recipe", Toast.LENGTH_SHORT).show()
                            println("AddRecipeFragment: Response: ${response.errorBody()?.string()}")
                        }
                    }

                    override fun onFailure(call: Call<UploadResepResponse>, t: Throwable) {
                        Toast.makeText(context, "Error", Toast.LENGTH_SHORT).show()
                        println("AddRecipeFragment: Failure: ${t.message}")
                    }
                })
            } else {
                Toast.makeText(context, "Selected file is not an image", Toast.LENGTH_SHORT).show()
            }
        } else {
            Toast.makeText(context, "Failed to get image path", Toast.LENGTH_SHORT).show()
        }
    }

    private fun onGalleryActivityResult(result: androidx.activity.result.ActivityResult) {
        if (result.resultCode == AppCompatActivity.RESULT_OK) {
            val data: Intent? = result.data
            if (data != null && data.data != null) {
                selectedImageUri = data.data
                Glide.with(this)
                    .load(selectedImageUri)
                    .fitCenter()
                    .into(binding.btnAddPhoto)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
