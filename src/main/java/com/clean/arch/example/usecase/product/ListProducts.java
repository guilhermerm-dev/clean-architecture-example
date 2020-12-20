package com.clean.arch.example.usecase.product;

import com.clean.arch.example.domain.entities.Product;
import com.clean.arch.example.gateway.ProductGateway;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Log4j
public class ListProducts {
    ProductGateway productGateway;

    public List<Product> execute() {
        log.info("Listing all products through use case ListAllProducts");
        return productGateway.listProducts();
    }
}
