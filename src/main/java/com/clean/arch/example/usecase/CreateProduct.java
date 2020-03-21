package com.clean.arch.example.usecase;

import com.clean.arch.example.config.error.exception.ValidationException;
import com.clean.arch.example.config.error.model.Error;
import com.clean.arch.example.domain.entity.Product;
import com.clean.arch.example.domain.port.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class CreateProduct {

    ProductRepository productRepository;

    public void execute(Product product) {
        if (productRepository.checkIfExistProduct(product.getCode(), product.getName()))
            throw new ValidationException(Error.builder()
                    .identifier(product.getName())
                    .message("Product already been in data base")
                    .build());

        productRepository.save(product);
    }
}
