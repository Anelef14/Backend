package com.Metafp.CiudadAlDia.entity;

import com.Metafp.CiudadAlDia.dto.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")

public class User {
    @Id
    private String id;
    private String nombre;// faraz
    private String email;//null
    private String dni;//null
    private String password;
    private Role role;

}
