package com.clean.arch.example.domain.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter

@Table(schema = "store", name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;
    private int Code;
    private String Name;
    private String Description;
    private double Price;
    private int Quantity;
}
