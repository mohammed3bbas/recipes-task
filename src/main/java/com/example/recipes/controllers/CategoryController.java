package com.example.recipes.controllers;

import com.example.recipes.model.Category;
import com.example.recipes.service.CategoryServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {
//    @Autowired
    private final CategoryServices categoryServices;

    public CategoryController(CategoryServices categoryServices) {
        this.categoryServices = categoryServices;
    }

    @GetMapping()
    public List<Category> getAllCategories(){
        return categoryServices.findAllCategories();
    }




    @PostMapping()
    public Category addCategory(@RequestBody Category category){



        Category newCategory = categoryServices.addCategory(category);
        return newCategory;

    }

    @GetMapping("/{name}")
    public Long findIdByCategoryName(@PathVariable String name){
        return categoryServices.findCategoryByName(name).getCategoryId();
    }





}
