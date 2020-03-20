package com.clean.arch.example.usecase;

import com.clean.arch.example.domain.entity.Product;
import com.clean.arch.example.domain.port.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ListAllProducts {
    ProductRepository productRepository;

    public List<Product> execute() {
        return productRepository.listAllProducts();
    }
}
