package com.example.demo.services;

import com.example.demo.dto.CategoryDto;
import com.example.demo.models.Category;
import com.example.demo.response.CategoryResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public interface iCategoryService {
    Category getCategorybyid (Long id);
    List<Category> getAllCat();
    Category saveCategory (CategoryDto categoryDto);
    Category updateCategory(CategoryDto categoryDto, Long id);
//    Category updateCategory(Category category);
    void deleteCategory(Long id);
    Page<CategoryResponse> getAllCategories(PageRequest pageRequest);
}
