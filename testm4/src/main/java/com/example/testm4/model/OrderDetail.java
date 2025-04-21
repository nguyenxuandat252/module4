package com.example.testm4.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private int quantity;

    @ManyToOne
    @JoinColumn(name = "id_product", referencedColumnName = "id")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "id_order", referencedColumnName = "id")
    private Orders orders;
}