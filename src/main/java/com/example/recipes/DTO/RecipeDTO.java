package com.example.recipes.DTO;

import java.io.Serializable;

public class RecipeDTO  implements Serializable {
    private Long recipeId ;
    private  String name;
    private  int minutes;
    private String imageUrl;
    private  Long categoryId ;

    public RecipeDTO(Long recipeId, String name, int minutes, String imageUrl, Long categoryId) {
        this.recipeId = recipeId;
        this.name = name;
        this.minutes = minutes;
        this.imageUrl = imageUrl;
        this.categoryId = categoryId;
    }

    public Long getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(Long recipeId) {
        this.recipeId = recipeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }




}
