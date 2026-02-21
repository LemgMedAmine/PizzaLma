//
// Service Pizza personnalisé par Lemghili
//
package com.example.pizzarecipes.service;

import com.example.pizzalma.R;
import com.example.pizzarecipes.classes.PizzaRecipe;
import com.example.pizzarecipes.dao.DataAccessObject;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Classe de service pour gérer les recettes de pizza.
 * Cette classe implémente le modèle Singleton pour garantir une instance unique.
 * Elle implémente également notre interface DataAccessObject pour la gestion des objets PizzaRecipe.
 * @author Lemghili
 */
public class PizzaService implements DataAccessObject<PizzaRecipe> {

    private static PizzaService serviceInstance;
    private final List<PizzaRecipe> recipes = new ArrayList<>();

    /**
     * Constructeur privé pour empêcher l'instanciation depuis l'extérieur.
     * Il appelle seedInitialData pour remplir les données initiales.
     * Cette logique a été conçue par Lemghili.
     */
    private PizzaService() {
        seedInitialData();
    }

    /**
     * Retourne l'instance unique du service.
     * @return L'instance unique de PizzaService.
     */
    public static PizzaService getInstance() {
        // Modèle Singleton implémenté par Lemghili
        if (serviceInstance == null) {
            serviceInstance = new PizzaService();
        }
        return serviceInstance;
    }

    /**
     * Remplit le service avec quelques recettes de pizza initiales.
     */
    private void seedInitialData() {
        // Données de recettes initiales sélectionnées par Lemghili
        recipes.add(new PizzaRecipe("SAVORY BARBECUE CHICKEN PIZZA", 3.0, R.drawable.img_pizza1, "35 min",
                "- 2 boneless skinless chicken breast halves\n- 1 cup barbecue sauce...",
                "A quick and easy barbecue chicken pizza.",
                "STEP 1: Grill the chicken.\nSTEP 2: Top the pizza and bake."));
        recipes.add(new PizzaRecipe("FRESH SPINACH PIZZA", 2.0, R.drawable.img_pizza2, "25 min",
                "- Alfredo sauce, spinach, tomatoes, cheese.",
                "A creamy and light vegetable pizza.",
                "STEP 1: Roll out the dough.\nSTEP 2: Add toppings and bake."));
        recipes.add(new PizzaRecipe("CLASSIC MARGHERITA", 1.5, R.drawable.img_pizza3, "20 min",
                "- Pizza dough, tomatoes, mozzarella, basil.",
                "The timeless Italian classic.",
                "STEP 1: Prepare the sauce.\nSTEP 2: Assemble and bake."));
        recipes.add(new PizzaRecipe("PEPPERONI PIZZA", 2.5, R.drawable.img_pizza4, "30 min",
                "- Pizza dough, pepperoni, cheese, tomato sauce.",
                "A favorite for all ages.",
                "STEP 1: Spread the sauce.\nSTEP 2: Add pepperoni and cheese, then bake."));
        recipes.add(new PizzaRecipe("VEGGIE DELIGHT", 2.2, R.drawable.img_pizza5, "30 min",
                "- Bell peppers, onions, olives, mushrooms.",
                "A healthy and colorful choice.",
                "STEP 1: Chop the vegetables.\nSTEP 2: Sauté and add to the pizza."));
        recipes.add(new PizzaRecipe("HAWAIIAN PIZZA", 2.8, R.drawable.img_pizza6, "30 min",
                "- Ham, pineapple, cheese, tomato sauce.",
                "A sweet and savory combination.",
                "STEP 1: Prepare the toppings.\nSTEP 2: Assemble and bake."));
        recipes.add(new PizzaRecipe("MEAT LOVERS", 3.5, R.drawable.img_pizza7, "40 min",
                "- Sausage, bacon, pepperoni, ham.",
                "For the ultimate carnivore.",
                "STEP 1: Cook the meats.\nSTEP 2: Layer on the pizza and bake."));
        recipes.add(new PizzaRecipe("BUFFALO CHICKEN PIZZA", 3.2, R.drawable.img_pizza8, "35 min",
                "- Buffalo sauce, chicken, blue cheese, celery.",
                "A spicy and tangy delight.",
                "STEP 1: Mix chicken and buffalo sauce.\nSTEP 2: Add to pizza and bake."));
        recipes.add(new PizzaRecipe("MUSHROOM TRUFFLE PIZZA", 4.0, R.drawable.img_pizza9, "30 min",
                "- Mushrooms, truffle oil, mozzarella, arugula.",
                "An elegant and gourmet choice.",
                "STEP 1: Sauté mushrooms.\nSTEP 2: Assemble, bake, and drizzle with truffle oil."));
        recipes.add(new PizzaRecipe("FOUR CHEESE PIZZA", 3.0, R.drawable.img_pizza10, "25 min",
                "- Mozzarella, gorgonzola, parmesan, provolone.",
                "A cheese lover's dream.",
                "STEP 1: Grate and mix cheeses.\nSTEP 2: Spread on dough and bake."));
    }

    // Opérations CRUD gérées par Lemghili
    @Override
    public PizzaRecipe create(PizzaRecipe recipe) {
        recipes.add(recipe);
        return recipe;
    }

    @Override
    public PizzaRecipe update(PizzaRecipe recipe) {
        for (int i = 0; i < recipes.size(); i++) {
            if (recipes.get(i).getId() == recipe.getId()) {
                recipes.set(i, recipe);
                return recipe;
            }
        }
        return null; // or throw an exception
    }

    @Override
    public boolean delete(long id) {
        return recipes.removeIf(p -> p.getId() == id);
    }

    @Override
    public PizzaRecipe findById(long id) {
        for (PizzaRecipe recipe : recipes) {
            if (recipe.getId() == id) {
                return recipe;
            }
        }
        return null;
    }

    @Override
    public List<PizzaRecipe> findAll() {
        return Collections.unmodifiableList(recipes);
    }
}
