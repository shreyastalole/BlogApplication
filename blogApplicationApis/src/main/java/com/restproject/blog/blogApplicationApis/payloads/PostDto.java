package com.restproject.blog.blogApplicationApis.payloads;

import com.restproject.blog.blogApplicationApis.models.Category;
import com.restproject.blog.blogApplicationApis.models.User;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PostDto {

    @NotEmpty
    @NotBlank
    @Size(min = 5, message = "Title should have atleast 5 characters")
    private String postTitle;
    @NotEmpty
    @NotBlank
    @Size(min = 100,message = "Content must be atleast of 100 characters")
    private String postContent;
    private String imageLink;
    private Date addedDate;
    private UserDto user;
    private CategoryDto category;

}
