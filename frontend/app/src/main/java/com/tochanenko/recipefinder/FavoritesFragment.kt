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

class FavoritesFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_favorites, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        populateRecipesList(view)
        super.onViewCreated(view, savedInstanceState)
    }

    private fun populateRecipesList(view: View) {
        val recipesList = view.findViewById<View>(R.id.favorite_recipes_list) as RecyclerView

        val adapter = RecipesListAdapter(FavoritesList.getList())
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