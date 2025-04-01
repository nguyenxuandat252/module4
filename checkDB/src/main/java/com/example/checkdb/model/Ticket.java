package com.example.checkdb.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ticket")
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "quantity")
    private int quantity = 0;

    @Column(name = "price", nullable = false)
    private double price = 0.0;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private Status status = Status.UNPAID;

    @Column(name = "date_time", nullable = false)
    private LocalDateTime dateTime;

    private enum Status {
        PAID, UNPAID
    }

    @ManyToOne
    @JoinColumn(name = "id_customer", nullable = false)
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "id_trip", nullable = false)
    private Trip trip;

    @ManyToOne
    @JoinColumn(name = "id_revenue")
    private Revenue revenue;

    @ManyToOne
    @JoinColumn(name = "id_promotion")
    private Promotion promotion;

}
