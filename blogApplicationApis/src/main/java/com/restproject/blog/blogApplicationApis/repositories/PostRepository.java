package com.restproject.blog.blogApplicationApis.repositories;

import com.restproject.blog.blogApplicationApis.models.Category;
import com.restproject.blog.blogApplicationApis.models.Post;
import com.restproject.blog.blogApplicationApis.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post,Integer> {
    List<Post> findAllByCategory(Category category);
    List<Post> findAllByUser(User user);
}
