package com.clean.arch.example.gateway.presenters;

import com.clean.arch.example.domain.entities.Product;
import com.clean.arch.example.repository.entities.ProductTable;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ProductPresenter {
    public static Product presentToDomain(ProductTable productTable) {
        return Product.builder()
                .code(productTable.getCode())
                .description(productTable.getDescription())
                .name(productTable.getName())
                .quantity(productTable.getQuantity())
                .price(productTable.getPrice())
                .build();
    }

    public static List<Product> presentToDomain(List<ProductTable> productTable) {
        return Optional.ofNullable(productTable).orElseGet(Collections::emptyList)
                .stream().map(product -> Product.builder()
                        .code(product.getCode())
                        .description(product.getDescription())
                        .name(product.getName())
                        .quantity(product.getQuantity())
                        .price(product.getPrice())
                        .build()).collect(Collectors.toList());
    }

    public static ProductTable toProductTable(Product product) {
        return ProductTable.builder()
                .code(product.getCode())
                .description(product.getDescription())
                .name(product.getName())
                .price(product.getPrice())
                .quantity(product.getQuantity()).build();
    }
}
