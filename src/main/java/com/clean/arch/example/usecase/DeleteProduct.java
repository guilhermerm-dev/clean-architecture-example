package com.clean.arch.example.usecase;

import com.clean.arch.example.domain.port.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DeleteProduct {

    ProductRepository productRepository;

    public void execute(int productId) {
        productRepository.deleteProduct(productId);
    }
}
