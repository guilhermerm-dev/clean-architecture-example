package com.clean.arch.example.entrypoint.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Getter
@Builder
public class ProductDto {
    private int Code;
    private String Name;
    private String Description;
    private double Price;
    private int Quantity;
}
