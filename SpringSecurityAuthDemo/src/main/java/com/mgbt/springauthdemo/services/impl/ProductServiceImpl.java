package com.mgbt.springauthdemo.services.impl;

import com.mgbt.springauthdemo.entities.Product;
import com.mgbt.springauthdemo.exceptions.NotFoundException;
import com.mgbt.springauthdemo.repositories.ProductRepository;
import com.mgbt.springauthdemo.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    @Override
    public List<Product> getAll() {
        return productRepository.findAll();
    }

    @Override
    public Product findById(Long idProduct) {
        return productRepository.findById(idProduct).orElseThrow(() -> new NotFoundException("Product not found"));
    }

    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Override
    public void delete(Product product) {
        productRepository.delete(product);
    }
}
