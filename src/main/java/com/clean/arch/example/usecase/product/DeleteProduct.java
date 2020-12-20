package com.clean.arch.example.usecase.product;

import com.clean.arch.example.gateway.ProductGateway;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DeleteProduct {

    ProductGateway productGateway;

    public void execute(int code) {
        productGateway.deleteProduct(code);
    }
}
