package com.restproject.blog.blogApplicationApis.repositories;

import com.restproject.blog.blogApplicationApis.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
}
