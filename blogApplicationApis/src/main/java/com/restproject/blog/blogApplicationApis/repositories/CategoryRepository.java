package com.restproject.blog.blogApplicationApis.repositories;

import com.restproject.blog.blogApplicationApis.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
