package com.clean.arch.example.controllers.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Getter
@Builder
public class ProductDto {
    private int code;
    private String name;
    private String description;
    private double price;
    private int quantity;
}
