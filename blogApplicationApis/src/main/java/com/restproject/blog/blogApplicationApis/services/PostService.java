package com.restproject.blog.blogApplicationApis.services;

import com.restproject.blog.blogApplicationApis.payloads.PostDto;

import java.util.List;

public interface PostService {

//    Create
    PostDto createPost(PostDto postDto, int userId, int categoryId);

//    Read
//    Get 1 post
    PostDto getPost(int userId,int postId);
    PostDto getPost(int postId);

//    Get all Posts
    List<PostDto> getAllPosts();
//    Get all posts by User
    List<PostDto> getAllPostsByUser(int userId);
//    Get all posts by Category
    List<PostDto> getAllPostsByCategory(int categoryId);

//    Update post
    PostDto updatePost(PostDto postDto, int userId, int categoryId);

//    Delete post
    void deletePost(int userId, int postId);


}
