package org.spring.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class LoginDto {
    @NotBlank(message = "Email is mandatory")
    @Column(unique = true, nullable = false)
    @Email
    private String email;
    @Size(min = 2, message = "password must me greater then 2 or equal")
    @NotBlank(message = "password can not be empty")
    private String password;
}
