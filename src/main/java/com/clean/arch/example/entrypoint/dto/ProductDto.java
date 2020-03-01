package com.clean.arch.example.entrypoint.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ProductDto {
    private int Id;
    private String Name;
    private String Description;
    private int Quantity;
}
