package com.lpu.LibraryManagmentAPI.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lpu.LibraryManagmentAPI.Entity.CategoryEntity;
import com.lpu.LibraryManagmentAPI.Resopsitory.CategoryRepository;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    //  CREATE - Add new category
    public CategoryEntity addCategory(CategoryEntity category) {
        return categoryRepository.save(category);
    }

    //  READ - Get all categories
    public List<CategoryEntity> getAllCategories() {
        return categoryRepository.findAll();
    }

    // READ - Get category by ID
    public CategoryEntity getCategoryById(Long id) {
        return categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found with id: " + id));
    }

    // UPDATE - Update category name
    public CategoryEntity updateCategory(Long id, CategoryEntity updatedCategory) {
        CategoryEntity existing = categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found with id: " + id));

        existing.setName(updatedCategory.getName());

        return categoryRepository.save(existing);
    }

    //  DELETE - Delete category by ID
    public void deleteCategory(Long id) {
        if (!categoryRepository.existsById(id)) {
            throw new RuntimeException("Category not found with id: " + id);
        }
        categoryRepository.deleteById(id);
    }
}