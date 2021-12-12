package com.tochanenko.recipefinder

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.google.android.material.appbar.MaterialToolbar

class RecipeDetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recipe_details)

        val extras = intent.extras
        if (extras != null) {
            val idText = findViewById<TextView>(R.id.recipe_details_id)
            val id = extras.getInt("id")
            val title = extras.getString("title")
            val recipeDetailsToolbar = findViewById<MaterialToolbar>(R.id.recipe_details_toolbar)
            recipeDetailsToolbar.title = title
            idText.text = id.toString()
        }
    }
}