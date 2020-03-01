package com.clean.arch.example.usecase;

import com.clean.arch.example.domain.entity.Product;
import com.clean.arch.example.domain.port.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CreateProduct {

    ProductRepository productRepository;

    public void createProduct(Product product) {
        productRepository.createProduct(product);
    }
}
