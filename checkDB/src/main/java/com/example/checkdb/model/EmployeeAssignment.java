package com.example.checkdb.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "employees_assignment")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeAssignment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "id_trip", nullable = false)
    private Trip trip;

    @ManyToOne
    @JoinColumn(name = "id_driver1", nullable = false)
    private Employee driver1;

    @ManyToOne
    @JoinColumn(name = "id_driver2", nullable = false)
    private Employee driver2;

    @ManyToOne
    @JoinColumn(name = "id_assistant", nullable = false)
    private Employee assistant;
}
