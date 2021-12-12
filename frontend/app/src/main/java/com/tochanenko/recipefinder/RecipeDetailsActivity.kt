package com.tochanenko.recipefinder

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import com.google.android.material.appbar.MaterialToolbar
import com.squareup.picasso.Picasso
import org.json.JSONObject

class RecipeDetailsActivity : AppCompatActivity() {
    private val json = """
    {
    "id": "716426",
    "title": "Cauliflower, Brown Rice, and Vegetable Fried Rice",
    "readyInMinutes": 30,
    "servings": 8,
    "image": "https://spoonacular.com/recipeImages/716426-556x370.jpg",
    "summary": "Cauliflower, Brown Rice, and Vegetable Fried Rice might be a good recipe to expand your side dish recipe box. Watching your figure? This gluten free, dairy free, lacto ovo vegetarian, and vegan recipe has <b>192 calories</b>, <b>7g of protein</b>, and <b>6g of fat</b> per serving. For <b>$1.12 per serving</b>, this recipe <b>covers 19%</b> of your daily requirements of vitamins and minerals. This recipe serves 8. This recipe from fullbellysisters.blogspot.com has 3689 fans. This recipe is typical of Chinese cuisine. From preparation to the plate, this recipe takes about <b>30 minutes</b>. Head to the store and pick up peas, broccoli, salt, and a few other things to make it today. Overall, this recipe earns an <b>awesome spoonacular score of 100%</b>. Users who liked this recipe also liked <a href=\"https://spoonacular.com/recipes/vegetable-fried-brown-rice-36199\">Vegetable Fried Brown Rice</a>, <a href=\"https://spoonacular.com/recipes/vegetable-fried-cauliflower-rice-933261\">Vegetable Fried Cauliflower Rice</a>, and <a href=\"https://spoonacular.com/recipes/easy-vegetable-fried-brown-rice-with-egg-802042\">Easy Vegetable Fried Brown Rice with Egg</a>.",
    "instructions": "<ol><li><span></span>Remove the cauliflower's tough stem and reserve for another use. Using a food processor, pulse cauliflower florets until they resemble rice or couscous. You should end up with around four cups of \"cauliflower rice.\"</li><li>Heat 1T butter and 1T oil in a large skillet over medium heat. Add garlic and the white and light green pieces of scallion. Sauté about a minute.</li><li>Add the cauliflower to the pan. Stir to coat with oil, then spread out in pan and let sit; you want it cook a bit and to caramelize (get a bit brown), which will bring out the sweetness. After a couple of minutes, stir and spread out again.</li><li>Add cold rice (it separates easily, so it won't clump up during cooking), plus the additional grapeseed and coconut oil or butter. Raise heat to medium-high. Toss everything together and, again, spread the mixture out over the whole pan and press a bit into the bottom. Let it sit for about two minutes—so the rice can get toasted and a little crispy. Add the peas and broccoli and stir again. Drizzle soy sauce and toasted sesame oil over rice.</li><li>Cook for another minute or so and turn off heat. Add chopped scallion tops and toss.</li><li>I like to toast some sesame seeds in a dry pan; I sprinkle these and some more raw, chopped scallion over the top of the rice for added flavor and crunch.</li><li>Season to taste with salt and, if you'd like, more soy sauce. Keep in mind that if you're serving this with something salty and saucy (ie. teriyaki chicken) you may want to hold off on adding too much salt to the fried rice.</li></ol>",
    "sourceUrl": "http://fullbellysisters.blogspot.com/2012/01/cauliflower-fried-rice-more-veggies.html",
    "ingredients": [
        {
            "id": "11090",
            "name": "broccoli",
            "amount": 2.0,
            "unit": "cups"
        },
        {
            "id": "11135",
            "name": "cauliflower",
            "amount": 1.0,
            "unit": "head"
        },
        {
            "id": "4047",
            "name": "coconut oil",
            "amount": 1.0,
            "unit": ""
        },
        {
            "id": "20041",
            "name": "cooked brown rice",
            "amount": 3.0,
            "unit": "cups"
        },
        {
            "id": "11215",
            "name": "garlic",
            "amount": 5.0,
            "unit": "cloves"
        },
        {
            "id": "4517",
            "name": "grapeseed oil",
            "amount": 1.0,
            "unit": ""
        },
        {
            "id": "16424",
            "name": "low sodium soy sauce",
            "amount": 3.0,
            "unit": "T"
        },
        {
            "id": "11304",
            "name": "peas",
            "amount": 1.0,
            "unit": "cup"
        },
        {
            "id": "2047",
            "name": "salt",
            "amount": 8.0,
            "unit": "servings"
        },
        {
            "id": "11291",
            "name": "scallion",
            "amount": 8.0,
            "unit": "servings"
        },
        {
            "id": "11291",
            "name": "scallions",
            "amount": 7.0,
            "unit": ""
        },
        {
            "id": "4058",
            "name": "sesame oil",
            "amount": 2.0,
            "unit": "t"
        },
        {
            "id": "12023",
            "name": "sesame seeds",
            "amount": 8.0,
            "unit": "servings"
        }
    ]
}"""
    private val jsonObject = JSONObject(json)

    lateinit var imageView: ImageView
    lateinit var titleTextView: TextView
    lateinit var timeTextView: TextView
    lateinit var servingsTextView: TextView
    lateinit var resourceLinkButton: Button
    lateinit var summaryTextView: TextView
    lateinit var instructionTextView: TextView
    lateinit var recipeDetailsToolbar: MaterialToolbar
    lateinit var favoritesButton: ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recipe_details)

        connectViews()
        val recipe = getRecipe()

        Picasso.get().load(recipe.image).into(imageView)
        titleTextView.text = recipe.title
        timeTextView.text = "${recipe.readyInMinutes} minutes"
        servingsTextView.text = "${recipe.servings} servings"
        // TODO ADD LINK TO BUTTON
        summaryTextView.text = recipe.summary
        instructionTextView.text = recipe.instructions

        recipeDetailsToolbar.title = recipe.title

    }

    private fun getRecipe(): RecipeDTO {
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

        return RecipeDTO(
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
    }


    private fun connectViews() {
        val extras = intent.extras
        if (extras == null) finish()

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
}