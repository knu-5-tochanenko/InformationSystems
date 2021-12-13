package com.tochanenko.recipefinder

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class IngredientListAdapter (private val ingredients: List<IngredientDTO>) : RecyclerView.Adapter<IngredientListAdapter.ViewHolder>() {
    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val nameTextView: TextView = view.findViewById(R.id.ingredient_item_name)
        val amountUnitTextView: TextView = view.findViewById(R.id.ingredient_item_amount_unit)
        val buttonUrl: Button = view.findViewById(R.id.ingredient_item_url)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        val contactView = inflater.inflate(R.layout.ingredient_list_item, parent, false)
        return ViewHolder(contactView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val ingredient: IngredientDTO = ingredients[position]
        val nameTextView = holder.nameTextView
        val amountUnitTextView = holder.amountUnitTextView
        val buttonUrl = holder.buttonUrl

        nameTextView.text = ingredient.name
        amountUnitTextView.text = "${ingredient.amount} ${ingredient.unit}"
    }

    override fun getItemCount(): Int {
        return ingredients.size
    }
}