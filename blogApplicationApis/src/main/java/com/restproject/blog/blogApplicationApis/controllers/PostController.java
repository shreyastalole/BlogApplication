package com.restproject.blog.blogApplicationApis.controllers;

import com.restproject.blog.blogApplicationApis.payloads.PostDto;
import com.restproject.blog.blogApplicationApis.services.PostService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
public class PostController {

    @Autowired
    PostService postService;

//    Create Post
    @PostMapping("/users/{userId}/categories/{categoryId}/posts")
    @ResponseStatus(HttpStatus.CREATED)
    PostDto createNewPost(@Valid @RequestBody PostDto postDto, @PathVariable int userId, @PathVariable int categoryId){
        return postService.createPost(postDto,userId,categoryId);
    }

//    Get Post by post id
    @GetMapping("/posts/{postId}")
    PostDto fetchPost(@PathVariable int postId){
        return postService.getPost(postId);
    }
//    Get all posts
    @GetMapping("/posts")
    List<PostDto> fetchAllPosts(){
        return postService.getAllPosts();
    }



}
