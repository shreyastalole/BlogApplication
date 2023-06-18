package com.restproject.blog.blogApplicationApis.payloads;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class UserDto {
    private int id;
    @NotEmpty(message = "name: Field cannot be empty")
    private String name;
    @Email(message = "Email is invalid")
    private String email;
    @NotEmpty(message = "Password cannot be empty")
    @Min(value = 8, message = "Password should have at least 8 characters")
    @Max(value = 20,message = "Password should have at max 20 characters")
    private String password;
    @NotNull(message = "Invalid entry for field: about")
    private String about;
}
