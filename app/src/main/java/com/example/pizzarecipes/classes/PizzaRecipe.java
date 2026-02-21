package com.example.pizzarecipes.classes;

/**
 * Represents a single pizza recipe.
 * This class is a simple Plain Old Java Object (POJO)
 * that holds all the information about a pizza.
 */
public class PizzaRecipe {
    private static long nextId = 1; // Used for auto-incrementing in-memory IDs

    private long id;
    private String name;
    private double price;
    private int imageResourceId;
    private String preparationTime;
    private String ingredients;
    private String description;
    private String preparationSteps;

    /**
     * Default constructor. Assigns a new unique ID.
     */
    public PizzaRecipe() {
        this.id = nextId++;
    }

    /**
     * Constructs a new PizzaRecipe with all its properties.
     * @param name The name of the pizza.
     * @param price The price of the pizza.
     * @param imageResourceId The resource ID for the pizza's image.
     * @param preparationTime The estimated time for preparation.
     * @param ingredients A string listing the ingredients.
     * @param description A short description of the pizza.
     * @param preparationSteps The steps to prepare the pizza.
     */
    public PizzaRecipe(String name, double price, int imageResourceId, String preparationTime,
                       String ingredients, String description, String preparationSteps) {
        this.id = nextId++;
        this.name = name;
        this.price = price;
        this.imageResourceId = imageResourceId;
        this.preparationTime = preparationTime;
        this.ingredients = ingredients;
        this.description = description;
        this.preparationSteps = preparationSteps;
    }

    // Getters and Setters

    public long getId() { return id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }
    public int getImageResourceId() { return imageResourceId; }
    public void setImageResourceId(int imageResourceId) { this.imageResourceId = imageResourceId; }
    public String getPreparationTime() { return preparationTime; }
    public void setPreparationTime(String preparationTime) { this.preparationTime = preparationTime; }
    public String getIngredients() { return ingredients; }
    public void setIngredients(String ingredients) { this.ingredients = ingredients; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public String getPreparationSteps() { return preparationSteps; }
    public void setPreparationSteps(String preparationSteps) { this.preparationSteps = preparationSteps; }

    @Override
    public String toString() {
        return name + " - " + price + " €";
    }
}
