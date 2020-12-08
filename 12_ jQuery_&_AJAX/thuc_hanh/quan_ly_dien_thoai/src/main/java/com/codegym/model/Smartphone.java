package com.codegym.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "smartphones")
@Data
public class Smartphone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer id;
    private String producer;
    private String model;
    private String price;

}
