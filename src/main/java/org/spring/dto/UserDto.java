package org.spring.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class UserDto {
    @NotBlank(message = "Name is mandatory")
    private String userName;
    @NotBlank(message = "Email is mandatory")
    @Column(unique = true, nullable = false)
    @Email
    private String email;
    @Size(min = 2, message = "password must me greater then 2 or equal")
    @NotBlank(message = "password can not be empty")
    private String password;
    @NotEmpty
    @NotNull(message = "repassword can not be empty")
    private String rePassword;
}
