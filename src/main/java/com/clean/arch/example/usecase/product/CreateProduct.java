package com.clean.arch.example.usecase.product;

import com.clean.arch.example.config.error.exception.ValidationException;
import com.clean.arch.example.config.error.model.Error;
import com.clean.arch.example.domain.entities.Product;
import com.clean.arch.example.gateway.ProductGateway;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CreateProduct {

    ProductGateway productGateway;

    public void execute(Product product) {
        if (productGateway.checkIfProductAlreadyExists(product.getCode(), product.getName()))
            throw new ValidationException(Error.builder()
                    .identifier(product.getName())
                    .message("Product code: " + product.getCode() + ", already been in data base")
                    .build());

        productGateway.createProduct(product);
    }
}
