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

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [SearchFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SearchFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_search, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        populateRecipesList(view)
        super.onViewCreated(view, savedInstanceState)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment SearchFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            SearchFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
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