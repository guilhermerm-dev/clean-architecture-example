package com.clean.arch.example.entrypoint.converters;

import com.clean.arch.example.domain.entity.Product;
import com.clean.arch.example.entrypoint.dto.ProductDto;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ProductConverter {
    public static Product toDomain(ProductDto productDto) {
        return Product.builder()
                .Code(productDto.getCode())
                .Description(productDto.getDescription())
                .Name(productDto.getName())
                .Quantity(productDto.getQuantity())
                .Price(productDto.getPrice())
                .build();
    }

    public static List<ProductDto> toDtos(List<Product> products) {
        return products.stream().map(product -> ProductDto.builder()
                .Code(product.getCode())
                .Description(product.getDescription())
                .Name(product.getName())
                .Price(product.getPrice())
                .Quantity(product.getQuantity()).build()).collect(Collectors.toList());
    }

    public static ProductDto toDto(Product product) {
        return ProductDto.builder()
                .Code(product.getCode())
                .Description(product.getDescription())
                .Name(product.getName())
                .Price(product.getPrice())
                .Quantity(product.getQuantity()).build();
    }
}
