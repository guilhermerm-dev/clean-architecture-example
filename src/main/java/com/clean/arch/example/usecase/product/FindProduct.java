package com.clean.arch.example.usecase.product;

import com.clean.arch.example.config.error.exception.ValidationException;
import com.clean.arch.example.config.error.model.Error;
import com.clean.arch.example.domain.entities.Product;
import com.clean.arch.example.gateway.ProductGateway;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class FindProduct {

    ProductGateway productGateway;

    public Product execute(int code) {
        Product product = productGateway.findProduct(code);
        if (product == null)
            throw new ValidationException(Error.builder()
                    .message("Product code: " + code + ", not found")
                    .build());

        return product;
    }

}
