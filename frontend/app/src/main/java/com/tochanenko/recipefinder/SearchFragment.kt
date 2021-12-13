package com.tochanenko.recipefinder

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import org.json.JSONArray
import org.json.JSONObject

class SearchFragment : Fragment() {
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
        val queue = Volley.newRequestQueue(view.context)
        val url = "https://glacial-lake-83393.herokuapp.com/recipe?number=5&offset=0"

        val stringRequest = StringRequest(
            Request.Method.GET, url,
            { response -> val recipesJsonList: JSONArray = JSONObject(response).getJSONArray("recipes")
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
            },
            {
                // that didn't work
            })

        queue.add(stringRequest)
    }
}