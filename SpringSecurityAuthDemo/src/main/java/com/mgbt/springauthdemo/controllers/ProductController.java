package com.mgbt.springauthdemo.controllers;

import com.mgbt.springauthdemo.entities.Product;
import com.mgbt.springauthdemo.services.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/products")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping(value = "")
    public ResponseEntity<?> getAll() {
        List<Product> products = productService.getAll();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        Product product = productService.findById(id);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @PostMapping(value = "")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> create(@Valid @RequestBody Product product) {
        productService.save(product);
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Product created");
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping(value = "")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> update(@Valid @RequestBody Product product) {
        productService.save(product);
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Product updated");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {
        Product product = productService.findById(id);
        productService.delete(product);
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Product deleted");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
