package com.mgbt.springauthdemo.services;

import com.mgbt.springauthdemo.entities.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {
    List<Product> getAll();
    Product findById(Long idProduct);
    Product save(Product product);
    void delete(Product product);
}
