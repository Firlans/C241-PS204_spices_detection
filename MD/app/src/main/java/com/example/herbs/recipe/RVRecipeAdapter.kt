package com.example.herbs.recipe

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.herbs.R
import com.example.herbs.response.DataItem

class RVRecipeAdapter(
    private val context: Context,
    private var dataList: List<DataItem>
) : RecyclerView.Adapter<RVRecipeAdapter.MyViewHolder>() {

    class MyViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        val tvNama: TextView = view.findViewById(R.id.tv_name_recipe)
        val tvAsal: TextView = view.findViewById(R.id.tv_asalresep)
        val tvAuthor: TextView = view.findViewById(R.id.tv_author)
        val cvRecipe: CardView = view.findViewById(R.id.cv_resep)
        val recipeImage: ImageView = view.findViewById(R.id.recipe_image)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val itemView = layoutInflater.inflate(R.layout.item_recipe, parent, false)
        return MyViewHolder(itemView)
    }

    override fun getItemCount(): Int = dataList.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val recipe = dataList[position]
        holder.tvNama.text = recipe.name
        holder.tvAsal.text = recipe.asalDaerah
        holder.tvAuthor.text = recipe.author

        val imageUrl = recipe.idPicture
        Glide.with(context)
            .load(imageUrl)
//            .placeholder(R.drawable.loading_placeholder)
//            .error(R.drawable.error_placeholder)
            .into(holder.recipeImage)

//        val imageUrl = "https://story-api.dicoding.dev/rhttps://story-api.dicoding.dev/images/stories/photos-1641623658595_dummy-pic.png"

        holder.cvRecipe.setOnClickListener {
            val intent = Intent(context, DetailRecipeActivity::class.java).apply {
                putExtra("recipe_id",recipe.id)
                putExtra("recipe_name", recipe.name)
                putExtra("recipe_author", recipe.author)
                putExtra("recipe_asal", recipe.asalDaerah)
                putExtra("recipe_bahan", recipe.bahan.joinToString("\n"){ "- $it" })
                putExtra("recipe_langkah", recipe.langkahPembuatan.joinToString("\n"){ "- $it" })
                putExtra("recipe_description", recipe.description)
                putExtra("recipe_picture", recipe.idPicture)
            }
            context.startActivity(intent)
        }
    }

    fun setData(data: List<DataItem>) {
        dataList = data
        notifyDataSetChanged()
    }
}