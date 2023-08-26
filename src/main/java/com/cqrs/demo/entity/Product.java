package com.cqrs.demo.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Entity
@Table(name = "product")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long Id;
    @Column(name = "ProductName")
    private String ProductName;
    @Column(name = "ProductPrice")
    private double ProductPrice;
    @Column(name = "ProductDescription")
    private String ProductDescription;
    @Column(name = "ProductQTY")
    private int ProductQTY;
}
