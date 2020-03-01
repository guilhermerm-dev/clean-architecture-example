package com.clean.arch.example.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;

@AllArgsConstructor
@Builder
public class Product {

    private int Id;
    private String Name;
    private String Description;
    private int Quantity;
}
