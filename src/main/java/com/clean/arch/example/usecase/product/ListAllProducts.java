package com.clean.arch.example.usecase.product;

import com.clean.arch.example.domain.entity.Product;
import com.clean.arch.example.domain.port.ProductRepository;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Log4j
public class ListAllProducts {
    ProductRepository productRepository;

    public List<Product> execute() {
        log.info("Listing all products through use case ListAllProducts");
        return productRepository.listAllProducts();
    }
}
