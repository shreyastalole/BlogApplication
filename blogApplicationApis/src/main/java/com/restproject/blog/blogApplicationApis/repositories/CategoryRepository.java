package com.restproject.blog.blogApplicationApis.repositories;

import com.restproject.blog.blogApplicationApis.models.Category;
import com.restproject.blog.blogApplicationApis.models.Post;
import com.restproject.blog.blogApplicationApis.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
