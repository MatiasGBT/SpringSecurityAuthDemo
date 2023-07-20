package com.mgbt.springauthdemo.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "roles", schema = "spring_auth_demo")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idRole;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private RolesEnum name;

}
