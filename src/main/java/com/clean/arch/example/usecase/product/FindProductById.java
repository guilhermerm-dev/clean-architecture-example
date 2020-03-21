package com.clean.arch.example.usecase.product;

import com.clean.arch.example.config.error.exception.ValidationException;
import com.clean.arch.example.config.error.model.Error;
import com.clean.arch.example.domain.entity.Product;
import com.clean.arch.example.domain.port.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class FindProductById {

    ProductRepository productRepository;

    public Product execute(int code) {
        Product product = productRepository.findProductById(code);
        if (product == null)
            throw new ValidationException(Error.builder()
                    .message("Product code: " + code + ", not found")
                    .build());

        return product;
    }

}
