package com.Metafp.CiudadAlDia.dto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.validation.constraints.NotNull;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private String id;
    @NotNull(message = "Nombre is required")
    private String nombre;

    @NotNull(message = "Email is required")
    private String email;

    @NotNull(message = "DNI is required")
    @Pattern(regexp = "\\d{8}[A-Za-z]", message = "Invalid DNI format")
    private String dni;

    @NotNull(message = "Role is required")
    private Role role;
    @NotBlank(message = "Password is required")
    @Pattern(
            regexp = "^(?=.*[A-Z])(?=.*[!@#$%^&*()_+=\\-{}|:;\"'<>,.?/]).{8,}$",
            message = "Password must be at least 8 characters long, contain one uppercase letter and one special character"
    )

    private String password;
}
