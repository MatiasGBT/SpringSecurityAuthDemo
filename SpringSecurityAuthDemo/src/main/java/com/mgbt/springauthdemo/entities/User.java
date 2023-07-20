package com.mgbt.springauthdemo.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@Entity
@Table(name = "users", schema = "spring_auth_demo")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_user")
    private Long idUser;

    @Column(name = "username")
    @NotBlank(message = "Username is mandatory")
    @Size(max = 20, message = "Username cannot exceed 20 characters")
    private String username;

    @Column(name = "email")
    @NotBlank(message = "Email is mandatory")
    @Size(max = 60, message = "Email cannot exceed 60 characters")
    @Email
    private String email;

    @Column(name = "password")
    @NotBlank(message = "Password is mandatory")
    @Size(max = 120, message = "Password cannot exceed 120 characters")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    @Column(name = "name")
    @NotBlank(message = "Name is mandatory")
    @Size(max = 30, message = "Name cannot exceed 30 characters")
    private String name;

    @Column(name = "last_name")
    @Size(max = 30, message = "Last name cannot exceed 30 characters")
    private String lastName;

    @Column(name = "photo")
    @Size(max = 30, message = "Photo cannot exceed 80 characters")
    private String photo;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_roles",
            schema = "spring_auth_demo",
            joinColumns = @JoinColumn(name = "id_user"),
            inverseJoinColumns = @JoinColumn(name = "id_role"))
    private Set<Role> roles = new HashSet<>();

    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }
}
