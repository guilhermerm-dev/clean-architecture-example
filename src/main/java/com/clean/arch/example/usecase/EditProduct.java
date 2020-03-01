package com.clean.arch.example.usecase;

import com.clean.arch.example.domain.port.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EditProduct {

    ProductRepository productRepository;

    public void editProduct() {
        productRepository.editProduct();
    }
}
