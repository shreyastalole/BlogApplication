package com.restproject.blog.blogApplicationApis.payloads;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDto {
    private Integer categoryId;
    @NotBlank
    @Size(min = 4,max = 30,message = "Title of the Category must have size between 4 and 30")
    private String categoryTitle;
    @NotEmpty(message = "Category Description cannot be Empty")
    private String categoryDescription;
}
