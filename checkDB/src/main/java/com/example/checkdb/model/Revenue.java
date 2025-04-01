package com.example.checkdb.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "revenue")
public class Revenue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "date_time", nullable = false)
    private LocalDate dateTime;

    @OneToMany(mappedBy = "revenue", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Ticket> ticketList;
}
