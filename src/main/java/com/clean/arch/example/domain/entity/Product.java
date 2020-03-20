package com.clean.arch.example.domain.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter

@Table(schema = "store", name = "product")
public class Product {

    @Id
    private int Id;
    private String Name;
    private String Description;
    private int Quantity;
}
