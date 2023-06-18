package com.restproject.blog.blogApplicationApis.services;

import com.restproject.blog.blogApplicationApis.payloads.CategoryDto;

import java.util.List;

public interface CategoryService {
//    Create
    CategoryDto createCategory(CategoryDto categoryDto);
//    Read
    CategoryDto getCategory(int categoryId);
    List<CategoryDto> getAllCategories();
//    Update
    CategoryDto updateCategory(CategoryDto categoryDto, int categoryId);
//    Delete
    void deleteCategory(int categoryId);

}
