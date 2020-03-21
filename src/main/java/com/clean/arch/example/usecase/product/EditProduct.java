package com.clean.arch.example.usecase.product;

import com.clean.arch.example.domain.entity.Product;
import com.clean.arch.example.domain.port.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class EditProduct {

    ProductRepository productRepository;

    public void execute(Product product) {
        productRepository.editProduct(product.getId(), product.getName(), product.getDescription(),
                product.getQuantity(), product.getPrice());
    }
}
