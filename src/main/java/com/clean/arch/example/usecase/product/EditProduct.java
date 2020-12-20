package com.clean.arch.example.usecase.product;

import com.clean.arch.example.domain.entities.Product;
import com.clean.arch.example.gateway.ProductGateway;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EditProduct {

    ProductGateway productGateway;

    public void execute(Product product) {
        productGateway.editProduct(product.getId(), product.getName(), product.getDescription(),
                product.getQuantity(), product.getPrice());
    }
}
