package com.example.api.model;

public class Recipe {
    private Long id;
    private String name;
    private String cuisine;
    private int prepTime;
    private String difficulty;
    private String[] ingredients;
    private String[] instructions;

    public Recipe(Long id, String name, String cuisine, int prepTime,
            String difficulty, String[] ingredients, String[] instructions) {
        this.id = id;
        this.name = name;
        this.cuisine = cuisine;
        this.prepTime = prepTime;
        this.difficulty = difficulty;
        this.ingredients = ingredients;
        this.instructions = instructions;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCuisine() {
        return cuisine;
    }

    public void setCuisine(String cuisine) {
        this.cuisine = cuisine;
    }

    public int getPrepTime() {
        return prepTime;
    }

    public void setPrepTime(int prepTime) {
        this.prepTime = prepTime;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public String[] getIngredients() {
        return ingredients;
    }

    public void setIngredients(String[] ingredients) {
        this.ingredients = ingredients;
    }

    public String[] getInstructions() {
        return instructions;
    }

    public void setInstructions(String[] instructions) {
        this.instructions = instructions;
    }
}
