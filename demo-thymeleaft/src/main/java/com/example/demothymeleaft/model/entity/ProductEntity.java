package com.example.demothymeleaft.model.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "product")
@Data
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Float price;

    private Integer quantity;

    private Integer discount;

    private Integer status;


}
