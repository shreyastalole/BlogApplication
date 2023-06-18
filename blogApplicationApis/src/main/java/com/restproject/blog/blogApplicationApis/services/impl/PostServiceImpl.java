package com.restproject.blog.blogApplicationApis.services.impl;

import com.restproject.blog.blogApplicationApis.exceptions.InvalidAccessException;
import com.restproject.blog.blogApplicationApis.exceptions.ResourceNotFoundException;
import com.restproject.blog.blogApplicationApis.models.Category;
import com.restproject.blog.blogApplicationApis.models.Post;
import com.restproject.blog.blogApplicationApis.models.User;
import com.restproject.blog.blogApplicationApis.payloads.PostDto;
import com.restproject.blog.blogApplicationApis.payloads.UserDto;
import com.restproject.blog.blogApplicationApis.repositories.CategoryRepository;
import com.restproject.blog.blogApplicationApis.repositories.PostRepository;
import com.restproject.blog.blogApplicationApis.repositories.UserRepository;
import com.restproject.blog.blogApplicationApis.services.PostService;
import com.restproject.blog.blogApplicationApis.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private PostRepository postRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public PostDto createPost(PostDto postDto, int userId, int categoryId) {

        User toSaveUser = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User","Id",userId));
        Category toSaveCategory = categoryRepository.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException("Category","Id",categoryId));
        Post toSavePost = modelMapper.map(postDto,Post.class);
        toSavePost.setImageLink("default.png");
        toSavePost.setAddedDate(new Date());
        toSavePost.setUser(toSaveUser);
        toSavePost.setCategory(toSaveCategory);

        Post savedPost = postRepository.save(toSavePost);
        return modelMapper.map(savedPost,PostDto.class);
    }

    @Override
    public PostDto getPost(int userId, int postId) {

        Post savedPost = postRepository.findById(postId).orElseThrow(()-> new ResourceNotFoundException("Post","Id",postId));
        if (savedPost.getUser().getId() != userId){
            throw new InvalidAccessException("User","Post","Accessing",userId,postId);
        }
        return modelMapper.map(savedPost,PostDto.class);
    }

    @Override
    public PostDto getPost(int postId) {
        Post savedPost = postRepository.findById(postId).orElseThrow(()-> new ResourceNotFoundException("Post","Id",postId));
        savedPost.getUser().setPassword(null);
        savedPost.getUser().setId(null);
        savedPost.getUser().setEmail(null);
        savedPost.getCategory().setCategoryId(null);
        return modelMapper.map(savedPost,PostDto.class);
    }

    @Override
    public List<PostDto> getAllPosts() {
        List<Post> allPosts = postRepository.findAll();
        return allPosts.stream().map(post ->{
            post.getUser().setPassword(null);
            post.getUser().setId(null);
            post.getUser().setEmail(null);
            return modelMapper.map(post,PostDto.class);
        }).collect(Collectors.toList());
    }

    @Override
    public List<PostDto> getAllPostsByUser(int userId) {
        return null;
    }

    @Override
    public List<PostDto> getAllPostsByCategory(int categoryId) {
        return null;
    }

    @Override
    public PostDto updatePost(PostDto postDto, int userId, int categoryId) {
        return null;
    }

    @Override
    public void deletePost(int userId, int postId) {

    }
}
