package com.clean.arch.example.usecase;

import com.clean.arch.example.domain.entity.Product;
import com.clean.arch.example.domain.port.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class FindProductById {

    ProductRepository productRepository;

    public Product execute(int productId) {
        return productRepository.findProductById(productId);
    }

}
