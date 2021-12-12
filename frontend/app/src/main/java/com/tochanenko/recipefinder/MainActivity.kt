package com.tochanenko.recipefinder

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.recyclerview.widget.DividerItemDecoration




class MainActivity : AppCompatActivity() {

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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        BottomNavigationView.OnNavigationItemSelectedListener { item ->
            when(item.itemId) {
                R.id.bottom_navigation_favorites -> {
                    true
                }
                R.id.bottom_navigation_search -> {
                    true
                }
                R.id.bottom_navigation_about -> {
                    true
                }
                else -> false
            }
        }

        val recipesList = findViewById<View>(R.id.recipes_list) as RecyclerView
        val recipes = arrayListOf(
            Recipe(
                1,
                "https://images.unsplash.com/photo-1512621776951-a57141f2eefd?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1470&q=80",
                "Super fancy dish"
            ),
            Recipe(
                1,
                "https://images.unsplash.com/photo-1504754524776-8f4f37790ca0?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1470&q=80",
                "Mega amount of dishes"
            ),
            Recipe(
                1,
                "https://images.unsplash.com/photo-1473093295043-cdd812d0e601?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1470&q=80",
                "Supa testiotto pazziatoo"
            ),
            Recipe(
                1,
                "https://images.unsplash.com/photo-1512621776951-a57141f2eefd?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1470&q=80",
                "Super fancy dish"
            ),
            Recipe(
                1,
                "https://images.unsplash.com/photo-1504754524776-8f4f37790ca0?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1470&q=80",
                "Mega amount of dishes"
            ),
            Recipe(
                1,
                "https://images.unsplash.com/photo-1473093295043-cdd812d0e601?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1470&q=80",
                "Supa testiotto pazziatoo"
            ),
            Recipe(
                1,
                "https://images.unsplash.com/photo-1512621776951-a57141f2eefd?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1470&q=80",
                "Super fancy dish"
            ),
            Recipe(
                1,
                "https://images.unsplash.com/photo-1504754524776-8f4f37790ca0?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1470&q=80",
                "Mega amount of dishes"
            ),
            Recipe(
                1,
                "https://images.unsplash.com/photo-1473093295043-cdd812d0e601?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1470&q=80",
                "Supa testiotto pazziatoo"
            )
        )

        val adapter = RecipesListAdapter(recipes)
        recipesList.adapter = adapter
        recipesList.addItemDecoration(
            DividerItemDecoration(
                recipesList.context,
                DividerItemDecoration.VERTICAL
            )
        )
        recipesList.layoutManager = LinearLayoutManager(this)
    }
}