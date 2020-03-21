package com.clean.arch.example.usecase.product;

import com.clean.arch.example.domain.port.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DeleteProduct {

    ProductRepository productRepository;

    public void execute(int code) {
        productRepository.deleteProduct(code);
    }
}
