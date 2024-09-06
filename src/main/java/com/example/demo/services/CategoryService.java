package com.example.demo.services;


import com.example.demo.dto.CategoryDto;
import com.example.demo.models.Category;
import com.example.demo.repository.HomeRepository;
import com.example.demo.response.CategoryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service

public class CategoryService implements iCategoryService {
    @Autowired
    HomeRepository homeRepository;


    @Override
    public Category getCategorybyid( Long id) {
        return  homeRepository.findById(id).orElse(null);
    }

    @Override
    public List<Category> getAllCat() {
        return homeRepository.findAll();
    }

    @Override
    public Category saveCategory( CategoryDto categoryDto) {
        Category category = Category
                .builder()
                .name(categoryDto.getAsdasdname())
                .build();
        return homeRepository.save(category);
    }

    @Override
    public Category updateCategory(CategoryDto categoryDto, Long id) {
        Category category1= getCategorybyid(id);
        category1.setName(categoryDto.getAsdasdname());
        category1.setUpdatedAt(LocalDateTime.now());
        return homeRepository.save(category1);
    }
    @Override
    public void deleteCategory(Long id) {
         homeRepository.deleteById(id);
    }

    @Override
    public Page<CategoryResponse> getAllCategories(PageRequest pageRequest) {
        return homeRepository.findAll(pageRequest).map(category -> {return CategoryResponse.fromCategory(category);});
    }
}
