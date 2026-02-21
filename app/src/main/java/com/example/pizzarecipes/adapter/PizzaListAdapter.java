package com.example.pizzarecipes.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.pizzalma.R;
import com.example.pizzarecipes.classes.PizzaRecipe;
import java.util.List;

/**
 * Custom adapter for displaying a list of pizza recipes.
 * This adapter is responsible for creating and binding views for each item in the list.
 */
public class PizzaListAdapter extends BaseAdapter {
    private final Context context;
    private final List<PizzaRecipe> pizzaRecipes;

    /**
     * Constructs a new PizzaListAdapter.
     * @param context The current context.
     * @param pizzaRecipes The list of pizza recipes to display.
     */
    public PizzaListAdapter(Context context, List<PizzaRecipe> pizzaRecipes) {
        this.context = context;
        this.pizzaRecipes = pizzaRecipes;
    }

    @Override
    public int getCount() {
        return pizzaRecipes.size();
    }

    @Override
    public Object getItem(int position) {
        return pizzaRecipes.get(position);
    }

    @Override
    public long getItemId(int position) {
        return pizzaRecipes.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.pizza_row_layout, parent, false);
        }

        ImageView pizzaImage = convertView.findViewById(R.id.pizzaImage);
        TextView pizzaName = convertView.findViewById(R.id.pizzaName);
        TextView pizzaMetadata = convertView.findViewById(R.id.pizzaMetadata);

        PizzaRecipe recipe = pizzaRecipes.get(position);
        pizzaImage.setImageResource(recipe.getImageResourceId());
        pizzaName.setText(recipe.getName());
        pizzaMetadata.setText(recipe.getPreparationTime() + " • " + recipe.getPrice() + " €");

        return convertView;
    }
}
