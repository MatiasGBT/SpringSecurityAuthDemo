package com.mgbt.springauthdemo.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
@Table(name = "products", schema = "spring_auth_demo")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_product")
    private Long idProduct;

    @Column(name = "name")
    @NotBlank(message = "Name is mandatory")
    @Size(max = 45, message = "Name cannot exceed 45 characters")
    private String name;

    @Column(name = "description")
    @NotBlank(message = "Description is mandatory")
    @Size(max = 200, message = "Description cannot exceed 200 characters")
    private String description;
}
