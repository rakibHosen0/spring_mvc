package org.spring.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UserDto {
    @NotBlank(message = "Name is mandatory")
    private String userName;
    @NotBlank(message = "Email is mandatory")
    @Column(unique = true, nullable = false)
    private String email;
    @Size(min = 3, message = "password must me greater then 3 or equal")
    @NotBlank(message = "password can not be empty")
    private String password;
    @NotNull(message = "repassword can not be empty")
    private String rePassword;
}
