package com.example.pizzarecipes.ui;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.pizzalma.R;
import com.example.pizzarecipes.adapter.PizzaListAdapter;
import com.example.pizzarecipes.classes.PizzaRecipe;
import com.example.pizzarecipes.service.PizzaService;
import java.util.List;

/**
 * This activity displays a list of available pizza recipes.
 * When a user clicks on a pizza, it navigates to the detail view.
 */
public class PizzaListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_pizza);

        ListView pizzaListView = findViewById(R.id.lvPizzas);
        List<PizzaRecipe> pizzaRecipes = PizzaService.getInstance().findAll();

        // Set the custom adapter for the list view
        pizzaListView.setAdapter(new PizzaListAdapter(this, pizzaRecipes));

        // Set a click listener to open the detail view
        pizzaListView.setOnItemClickListener((parent, view, position, id) -> {
            Intent intent = new Intent(this, PizzaDetailActivity.class);
            intent.putExtra("pizza_id", id);
            startActivity(intent);
        });
    }
}
