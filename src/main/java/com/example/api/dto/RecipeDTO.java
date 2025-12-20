package com.example.api.dto;

public class RecipeDTO {
    private Long id;
    private String name;
    private String cuisine;
    private Integer prepTime;
    private String difficulty;
    private String[] ingredients;
    private String[] instructions;
    
    public RecipeDTO() {}
    
    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    
    public String getCuisine() { return cuisine; }
    public void setCuisine(String cuisine) { this.cuisine = cuisine; }
    
    public Integer getPrepTime() { return prepTime; }
    public void setPrepTime(Integer prepTime) { this.prepTime = prepTime; }
    
    public String getDifficulty() { return difficulty; }
    public void setDifficulty(String difficulty) { this.difficulty = difficulty; }
    
    public String[] getIngredients() { return ingredients; }
    public void setIngredients(String[] ingredients) { this.ingredients = ingredients; }
    
    public String[] getInstructions() { return instructions; }
    public void setInstructions(String[] instructions) { this.instructions = instructions; }
}