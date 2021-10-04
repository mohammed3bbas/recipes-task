package com.example.recipes.service;


import com.example.recipes.DTO.CategoryDTO;
import com.example.recipes.model.Category;
import com.example.recipes.repo.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CategoryServices {
//    @Autowired
    private final CategoryRepo categoryRepo;

    public CategoryServices(CategoryRepo categoryRepo) {
        this.categoryRepo = categoryRepo;
    }
//  C
    public Category addCategory(Category category){

        if(categoryNameValid(category.getName())){
            return null;
        }

        return categoryRepo.save(category);
    }

    private boolean categoryNameValid(String name) {

        if(categoryRepo.getAllNames().contains(name)){
            return false;
        }
        return true;


    }

    //  R
    public List<Category> findAllCategories() {

        return categoryRepo.findAll();
    }


    public Optional<Category> findCategoryById(Long id){

        return categoryRepo.findById(id);
    }
    public Category findCategoryByName(String name){

        return categoryRepo.findByName(name).get(0);
    }
    public List<String> findCategoryNames(){
        return categoryRepo.getAllNames();
    }

//   U
    public Category updateCategory(Category category){
        Optional<Category> wantedCategory = categoryRepo.findById(category.getCategoryId());
        if(wantedCategory.isPresent()){
            return categoryRepo.save(category);
        }
        else {
            return null;
        }


    }
//   D
    public void deleteCategoryById(Long id){
        categoryRepo.deleteById(id);
    }
    public void deleteCategory(Category category){
        categoryRepo.delete(category);
    }
}
