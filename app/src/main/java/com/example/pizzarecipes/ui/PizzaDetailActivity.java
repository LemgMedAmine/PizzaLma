package com.example.pizzarecipes.ui;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.pizzalma.R;
import com.example.pizzarecipes.classes.PizzaRecipe;
import com.example.pizzarecipes.service.PizzaService;

/**
 * This activity displays the full details of a single pizza recipe.
 * It retrieves the pizza ID from the intent and loads the data.
 */
public class PizzaDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pizza_detail);

        // Retrieve the pizza ID from the intent that started this activity
        long pizzaId = getIntent().getLongExtra("pizza_id", -1);
        // Find the corresponding pizza recipe from our service
        PizzaRecipe recipe = PizzaService.getInstance().findById(pizzaId);

        // Get references to all the UI elements in the layout
        Button backButton = findViewById(R.id.backButton);
        ImageView pizzaImage = findViewById(R.id.detailPizzaImage);
        TextView pizzaName = findViewById(R.id.detailPizzaName);
        TextView pizzaMetadata = findViewById(R.id.detailPizzaMetadata);
        TextView pizzaIngredients = findViewById(R.id.detailPizzaIngredients);
        TextView pizzaDescription = findViewById(R.id.detailPizzaDescription);
        TextView pizzaSteps = findViewById(R.id.detailPizzaSteps);

        // Set a click listener for the back button
        backButton.setOnClickListener(v -> finish());

        // If a valid recipe was found, populate the UI
        if (recipe != null) {
            pizzaImage.setImageResource(recipe.getImageResourceId());
            pizzaName.setText(recipe.getName());
            pizzaMetadata.setText(recipe.getPreparationTime() + " • " + recipe.getPrice() + " €");
            pizzaIngredients.setText(recipe.getIngredients());
            pizzaDescription.setText(recipe.getDescription());
            pizzaSteps.setText(recipe.getPreparationSteps());
        } else {
            // Otherwise, display a "not found" message
            pizzaName.setText("Pizza not found!");
        }
    }
}
