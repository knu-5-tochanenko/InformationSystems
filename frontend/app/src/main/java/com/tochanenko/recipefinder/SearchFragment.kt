package com.tochanenko.recipefinder

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.json.JSONArray
import org.json.JSONObject

class SearchFragment : Fragment() {

    private val json = """
        {"recipes": [
                {
                    "id": 716426,
                    "title": "Cauliflower, Brown Rice, and Vegetable Fried Rice",
                    "image": "https://spoonacular.com/recipeImages/716426-312x231.jpg"
                },
                {
                    "id": 715594,
                    "title": "Homemade Garlic and Basil French Fries",
                    "image": "https://spoonacular.com/recipeImages/715594-312x231.jpg"
                },
                {
                    "id": 715497,
                    "title": "Berry Banana Breakfast Smoothie",
                    "image": "https://spoonacular.com/recipeImages/715497-312x231.jpg"
                },
                {
                    "id": 644387,
                    "title": "Garlicky Kale",
                    "image": "https://spoonacular.com/recipeImages/644387-312x231.jpg"
                },
                {
                    "id": 716268,
                    "title": "African Chicken Peanut Stew",
                    "image": "https://spoonacular.com/recipeImages/716268-312x231.jpg"
                },
                {
                    "id": 716381,
                    "title": "Nigerian Snail Stew",
                    "image": "https://spoonacular.com/recipeImages/716381-312x231.jpg"
                },
                {
                    "id": 782601,
                    "title": "Red Kidney Bean Jambalaya",
                    "image": "https://spoonacular.com/recipeImages/782601-312x231.jpg",
                    "imageType": "jpg"
                },
                {
                    "id": 794349,
                    "title": "Broccoli and Chickpea Rice Salad",
                    "image": "https://spoonacular.com/recipeImages/794349-312x231.jpg"
                },
                {
                    "id": 715446,
                    "title": "Slow Cooker Beef Stew",
                    "image": "https://spoonacular.com/recipeImages/715446-312x231.jpg"
                },
                {
                    "id": 715415,
                    "title": "Red Lentil Soup with Chicken and Turnips",
                    "image": "https://spoonacular.com/recipeImages/715415-312x231.jpg"
                }
            ]
        }
    """.trimIndent()
    private val jsonObject = JSONObject(json)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_search, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        populateRecipesList(view)
        super.onViewCreated(view, savedInstanceState)
    }

    private fun populateRecipesList(view: View) {
        val recipesJsonList: JSONArray = jsonObject.getJSONArray("recipes")
        val recipes = mutableListOf<Recipe>()

        for (i: Int in 0 until recipesJsonList.length()) {
            val recipeJsonObject = recipesJsonList.getJSONObject(i)
            recipes.add(
                Recipe(
                    recipeJsonObject.getInt("id"),
                    recipeJsonObject.getString("image"),
                    recipeJsonObject.getString("title")
                )
            )
        }

        val recipesList = view.findViewById<View>(R.id.recipes_list) as RecyclerView

        val adapter = RecipesListAdapter(recipes)
        recipesList.adapter = adapter
        recipesList.addItemDecoration(
            DividerItemDecoration(
                recipesList.context,
                DividerItemDecoration.VERTICAL
            )
        )
        recipesList.layoutManager = LinearLayoutManager(activity)
    }
}