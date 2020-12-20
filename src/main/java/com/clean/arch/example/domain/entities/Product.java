package com.clean.arch.example.domain.entities;

import lombok.*;

@Data
@Builder
public class Product {
    private int id;
    private int code;
    private String name;
    private String description;
    private double price;
    private int quantity;
}
