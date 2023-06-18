package com.restproject.blog.blogApplicationApis.payloads;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class UserDto {
    private Integer id;
    @NotEmpty(message = "name: Field cannot be empty")
    private String name;
    @Email(message = "Email is invalid")
    private String email;
    @NotEmpty(message = "Password cannot be empty")
    @Size(min = 4,max = 15, message = "Password should have at least 8 characters")
    private String password;
    @NotNull(message = "Invalid entry for field: about")
    private String about;
}
