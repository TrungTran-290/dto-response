package com.example.demo.controllers;

import com.example.demo.dto.CategoryDto;
import com.example.demo.models.Category;
import com.example.demo.response.CategoryListResponse;
import com.example.demo.response.CategoryResponse;
import com.example.demo.services.CategoryService;
import jakarta.validation.Valid;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/category")
public class CategoryController {
    @Autowired
    CategoryService categoryService;
    @GetMapping("")
    public List<Category> getAll(){
        return categoryService.getAllCat();
    }

    @PostMapping("/create")
    public ResponseEntity<?> createmore(@Valid @RequestBody CategoryDto categoryDto, BindingResult result){
    if(result.hasErrors()){
        List<String> cacLoi = result.getFieldErrors().stream()
                .map(FieldError::getDefaultMessage).toList();
        return ResponseEntity.badRequest().body(cacLoi);
    }
         categoryService.saveCategory(categoryDto);
        return ResponseEntity.ok("insert" +categoryDto);
    }

    @PutMapping("/update/{id}")
    public Category update(@RequestBody CategoryDto categoryDto, @PathVariable("id") long id){
        return categoryService.updateCategory(categoryDto,id);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable("id") long id){
        categoryService.deleteCategory(id);

        return "deleted" + id;
    }

    @GetMapping("/list")
    public ResponseEntity<CategoryListResponse> getAllCategories(@RequestParam int page,@RequestParam int limit){
        PageRequest pageRequest = PageRequest.of(
                page,limit, Sort.by("createdAt").descending()
        );
        Page<CategoryResponse> categoryResponsePage = categoryService.getAllCategories(pageRequest);
        int totalPages = categoryResponsePage.getTotalPages();
        List<CategoryResponse> categoryResponsePageContent = categoryResponsePage.getContent();
        return ResponseEntity.ok(CategoryListResponse.builder().categoryResponseList(categoryResponsePageContent)
                .totalPage(totalPages).build());
    }
}
