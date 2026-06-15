package com.lpu.LibraryManagmentAPI.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.lpu.LibraryManagmentAPI.Entity.CategoryEntity;
import com.lpu.LibraryManagmentAPI.Service.CategoryService;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    // POST /categories → Add new category
    @PostMapping
    public CategoryEntity addCategory(@RequestBody CategoryEntity category) {
        return categoryService.addCategory(category);
    }

    // GET /categories → Get all categories
    @GetMapping
    public List<CategoryEntity> getAllCategories() {
        return categoryService.getAllCategories();
    }

    // GET /categories/{id} → Get category by ID
    @GetMapping("/{id}")
    public CategoryEntity getCategoryById(@PathVariable Long id) {
        return categoryService.getCategoryById(id);
    }

    //PUT /categories/{id} → Update category
    @PutMapping("/{id}")
    public CategoryEntity updateCategory(@PathVariable Long id, @RequestBody CategoryEntity category) {
        return categoryService.updateCategory(id, category);
    }

    // DELETE /categories/{id} → Delete category
    @DeleteMapping("/{id}")
    public String deleteCategory(@PathVariable Long id) {
        categoryService.deleteCategory(id);
        return "Category deleted successfully with id: " + id;
    }
}