package com.example.recipes.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;
@Entity

public class Category implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //must assign primary keys
    @Column( name="category_id")
    private Long categoryId ;
    @Column(name="category_name",unique = true,nullable = false)
    private  String name;


    @OneToMany(mappedBy = "category",cascade = CascadeType.ALL)
    private Set<Recipe> recipe;



    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Recipe> getRecipe() {
        return recipe;
    }

    public void setRecipe(Set<Recipe> recipe) {
        this.recipe = recipe;
    }

    @Override
    public String toString() {
        return "Category{" +
                "categoryId=" + categoryId +
                ", name='" + name + '\'' +
                ", recipe=" + recipe +
                '}';
    }
}
