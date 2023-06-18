package com.restproject.blog.blogApplicationApis.controllers;

import com.restproject.blog.blogApplicationApis.payloads.ApiResponse;
import com.restproject.blog.blogApplicationApis.payloads.CategoryDto;
import com.restproject.blog.blogApplicationApis.services.impl.CategoryServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/categories/")
public class CategoryController {

    @Autowired
    CategoryServiceImpl categoryService;

//    Create
    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public CategoryDto createUser(@Valid @RequestBody CategoryDto categoryDto){
        return categoryService.createCategory(categoryDto);
    }
    
//    Get 1
    @GetMapping("/{categoryId}")
    @ResponseStatus(HttpStatus.OK)
    public CategoryDto fetchCategory(@PathVariable int categoryId){
        return categoryService.getCategory(categoryId);
    }
//    Get All
    @GetMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public List<CategoryDto> fetchCategories(){
        return categoryService.getAllCategories();
    }
//    Update
    @PutMapping("/{categoryId}")
    @ResponseStatus(HttpStatus.OK)
    public CategoryDto updateCategory(@PathVariable int categoryId,@Valid @RequestBody CategoryDto categoryDto){
        return categoryService.updateCategory(categoryDto,categoryId);
    }

//    Delete
    @DeleteMapping("/{categoryId}")
    @ResponseStatus(HttpStatus.OK)
    public ApiResponse deleteCategory(@PathVariable int categoryId){
        categoryService.deleteCategory(categoryId);
        return new ApiResponse("Category Deleted Successfully:",true);
    }

}
