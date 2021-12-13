package com.tochanenko.recipefinder

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import android.text.Spanned
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import com.google.android.material.appbar.MaterialToolbar
import com.squareup.picasso.Picasso
import org.json.JSONObject
import android.content.Intent
import android.net.Uri
import android.view.View
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley


class RecipeDetailsActivity : AppCompatActivity() {
    private lateinit var imageView: ImageView
    private lateinit var titleTextView: TextView
    private lateinit var timeTextView: TextView
    private lateinit var servingsTextView: TextView
    private lateinit var resourceLinkButton: Button
    private lateinit var summaryTextView: TextView
    private lateinit var instructionTextView: TextView
    private lateinit var recipeDetailsToolbar: MaterialToolbar
    private lateinit var favoritesButton: ImageButton

    private var id: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recipe_details)

        connectViews()
        val queue = Volley.newRequestQueue(this)
        val url = "https://glacial-lake-83393.herokuapp.com/recipe/" + this.id.toString()

        val stringRequest = StringRequest(
            Request.Method.GET, url,
            { response ->
                val jsonObject = JSONObject(response)
                val ingredients = mutableListOf<IngredientDTO>()
                val ingredientsJsonArray = jsonObject.getJSONArray("ingredients")
                for (i: Int in 0 until ingredientsJsonArray.length()) {
                    val ingredientJsonObject = ingredientsJsonArray.getJSONObject(i)
                    ingredients.add(IngredientDTO(
                        ingredientJsonObject.getInt("id"),
                        ingredientJsonObject.getString("name"),
                        ingredientJsonObject.getDouble("amount"),
                        ingredientJsonObject.getString("unit")
                    ))
                }

                val recipe = RecipeDTO(
                    jsonObject.getInt("id"),
                    jsonObject.getString("title"),
                    jsonObject.getInt("readyInMinutes"),
                    jsonObject.getInt("servings"),
                    jsonObject.getString("image"),
                    jsonObject.getString("summary"),
                    jsonObject.getString("instructions"),
                    jsonObject.getString("sourceUrl"),
                    ingredients
                )

                Picasso.get().load(recipe.image).into(imageView)
                titleTextView.text = recipe.title
                timeTextView.text = "${recipe.readyInMinutes} minutes"
                servingsTextView.text = "${recipe.servings} servings"
                summaryTextView.text = getHtmlText(recipe.summary)
                instructionTextView.text = getHtmlText(recipe.instructions)
                recipeDetailsToolbar.title = recipe.title
                favoritesButton.setImageResource(
                    if (FavoritesList.contains(recipe.id)) R.drawable.ic_round_favorite_24
                    else R.drawable.ic_round_favorite_border_24
                )
                resourceLinkButton.setOnClickListener {
                    val uri: Uri = Uri.parse(recipe.sourceUrl)
                    val intent = Intent(Intent.ACTION_VIEW, uri)
                    startActivity(intent)
                }

                favoritesButton.setOnClickListener {
                    if (FavoritesList.contains(recipe.id)) {
                        FavoritesList.delete(recipe.id)
                        favoritesButton.setImageResource(R.drawable.ic_round_favorite_border_24)
                    } else {
                        FavoritesList.add(recipe)
                        favoritesButton.setImageResource(R.drawable.ic_round_favorite_24)
                    }
                }

                populateIngredientsList(recipe)
            },
            {
                // that didn't work
            })

        queue.add(stringRequest)
    }


    private fun connectViews() {
        val extras = intent.extras
        if (extras == null) finish()
        this.id = extras!!.getInt("id")

        imageView = findViewById(R.id.recipe_details_img)
        titleTextView = findViewById(R.id.recipe_details_title)
        timeTextView = findViewById(R.id.recipe_details_time)
        servingsTextView = findViewById(R.id.recipe_details_servings)
        resourceLinkButton = findViewById(R.id.recipe_details_button)
        summaryTextView = findViewById(R.id.recipe_details_summary)
        instructionTextView = findViewById(R.id.recipe_details_instructions)
        recipeDetailsToolbar = findViewById(R.id.recipe_details_toolbar)
        favoritesButton = findViewById(R.id.recipe_details_favorite_button)

        recipeDetailsToolbar.setNavigationOnClickListener {
            finish()
        }
    }

    private fun populateIngredientsList(recipe: RecipeDTO) {
        val ingredientsList = findViewById<View>(R.id.ingredients_list) as RecyclerView

        val adapter = IngredientListAdapter(recipe.ingredients)
        ingredientsList.adapter = adapter
        ingredientsList.addItemDecoration(
            DividerItemDecoration(
                ingredientsList.context,
                DividerItemDecoration.VERTICAL
            )
        )
        ingredientsList.layoutManager = LinearLayoutManager(this)
    }

    private fun getHtmlText(html: String): Spanned = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N)
        Html.fromHtml(html, Html.FROM_HTML_MODE_COMPACT)
    else
        Html.fromHtml(html)

}