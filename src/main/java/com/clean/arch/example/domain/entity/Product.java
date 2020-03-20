package com.clean.arch.example.domain.entity;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class Product {

    private int Id;
    private String Name;
    private String Description;
    private int Quantity;
}
