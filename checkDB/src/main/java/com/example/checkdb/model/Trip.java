package com.example.checkdb.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "trip")
public class Trip {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "departure_time", nullable = false)
    private LocalDateTime departureTime;

    @Column(name = "expected_time", nullable = false)
    private String expectedTime;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private Status status = Status.NOTDEPARTED;

    @Column(name = "is_deleted")
    private Boolean isDeleted = false;

    private enum Status {
        NOTDEPARTED, DEPARTED, COMPLETED
    }

    @ManyToOne
    @JoinColumn(name = "id_bus_route", nullable = false)
    private BusRoute busRoute;

    @OneToMany(mappedBy = "trip", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<VehicleAssignment> vehicleAssignmentList;

    @OneToMany(mappedBy = "trip", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<EmployeeAssignment> employeeAssignment;

    @OneToMany(mappedBy = "trip", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Ticket> ticketList;

    @OneToMany(mappedBy = "trip", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Feedback> feedbackList;

}
