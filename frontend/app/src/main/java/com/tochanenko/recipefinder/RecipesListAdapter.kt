package com.tochanenko.recipefinder

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class RecipesListAdapter (private val recipes: List<Recipe>) : RecyclerView.Adapter<RecipesListAdapter.ViewHolder>() {

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val image = view.findViewById<ImageView>(R.id.recipes_list_item_img)
        val title = view.findViewById<TextView>(R.id.recipes_list_item_title)
        val info_button = view.findViewById<Button>(R.id.recipes_list_item_info)
        val favorite_button = view.findViewById<ImageButton>(R.id.recipes_list_item_favorite_button)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        val contactView = inflater.inflate(R.layout.recipes_list_item, parent, false)
        return ViewHolder(contactView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val recipe: Recipe = recipes[position]
        val image = holder.image
        val title = holder.title
        val info_button = holder.info_button
        val favoriteButton = holder.favorite_button

        favoriteButton.setImageResource(
            if (recipe.favorite) R.drawable.ic_round_favorite_24
            else R.drawable.ic_round_favorite_border_24
        )

        Picasso.get().load(recipe.imageUrl).into(image)
        title.text = recipe.title
    }

    override fun getItemCount(): Int {
        return recipes.size
    }
}