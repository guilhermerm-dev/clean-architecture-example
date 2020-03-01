package com.clean.arch.example.entrypoint.converters;

import com.clean.arch.example.domain.entity.Product;
import com.clean.arch.example.entrypoint.dto.ProductDto;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
class ProductConverter {
    public static Product toDomain(ProductDto productDto) {
        return Product.builder()
                .Id(productDto.getId())
                .Description(productDto.getDescription())
                .Name(productDto.getName())
                .Quantity(productDto.getQuantity()).build();
    }
}
