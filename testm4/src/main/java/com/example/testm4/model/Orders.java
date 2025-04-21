package com.example.testm4.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "date_buy")
    private LocalDate dateBuy;

    @JsonIgnore
    @OneToMany(mappedBy = "orders", cascade = CascadeType.ALL,orphanRemoval = true)
    List<OrderDetail> orderDetailList;
}
