package com.example.api.controller;

import com.example.api.dto.RecipeDTO;
import com.example.api.entity.Recipe;
import com.example.api.repository.RecipeRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/recipes")
public class RecipeController {
    private final RecipeRepository recipeRepository;
    
    public RecipeController(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }
    
    @GetMapping
    public List<RecipeDTO> getAllRecipes() {
        return recipeRepository.findAll().stream()
            .map(this::toDTO)
            .collect(Collectors.toList());
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<RecipeDTO> getRecipeById(@PathVariable Long id) {
        return recipeRepository.findById(id)
            .map(recipe -> ResponseEntity.ok(toDTO(recipe)))
            .orElse(ResponseEntity.notFound().build());
    }
    
    @PostMapping
    public RecipeDTO createRecipe(@RequestBody RecipeDTO dto) {
        Recipe recipe = toEntity(dto);
        return toDTO(recipeRepository.save(recipe));
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<RecipeDTO> updateRecipe(@PathVariable Long id, @RequestBody RecipeDTO dto) {
        return recipeRepository.findById(id)
            .map(recipe -> {
                recipe.setName(dto.getName());
                recipe.setCuisine(dto.getCuisine());
                recipe.setPrepTime(dto.getPrepTime());
                recipe.setDifficulty(dto.getDifficulty());
                recipe.setIngredients(String.join("||", dto.getIngredients()));
                recipe.setInstructions(String.join("||", dto.getInstructions()));
                return ResponseEntity.ok(toDTO(recipeRepository.save(recipe)));
            })
            .orElse(ResponseEntity.notFound().build());
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRecipe(@PathVariable Long id) {
        if (recipeRepository.existsById(id)) {
            recipeRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
    
    private RecipeDTO toDTO(Recipe recipe) {
        RecipeDTO dto = new RecipeDTO();
        dto.setId(recipe.getId());
        dto.setName(recipe.getName());
        dto.setCuisine(recipe.getCuisine());
        dto.setPrepTime(recipe.getPrepTime());
        dto.setDifficulty(recipe.getDifficulty());
        dto.setIngredients(recipe.getIngredients() != null ? recipe.getIngredients().split("\\|\\|") : new String[0]);
        dto.setInstructions(recipe.getInstructions() != null ? recipe.getInstructions().split("\\|\\|") : new String[0]);
        return dto;
    }
    
    private Recipe toEntity(RecipeDTO dto) {
        Recipe recipe = new Recipe();
        recipe.setName(dto.getName());
        recipe.setCuisine(dto.getCuisine());
        recipe.setPrepTime(dto.getPrepTime());
        recipe.setDifficulty(dto.getDifficulty());
        recipe.setIngredients(String.join("||", dto.getIngredients()));
        recipe.setInstructions(String.join("||", dto.getInstructions()));
        return recipe;
    }
}