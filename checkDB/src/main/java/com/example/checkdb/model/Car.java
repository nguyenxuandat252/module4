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
@Table(name = "car")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "license_plate", unique = true, nullable = false)
    private String licensePlate;

    @Enumerated(EnumType.STRING)
    @Column(name = "vehicle_type", nullable = false)
    private VehicleType vehicleType = VehicleType.STANDARD;

    @Column(name = "seat_number", nullable = false)
    private Integer seatNumber;

    @Enumerated(EnumType.STRING)
    @Column(name = "vehicle_status", nullable = false)
    private VehicleStatus vehicleStatus = VehicleStatus.ACTIVATE;

    @Column(name = "last_maintenance")
    private LocalDate lastMaintenance;

    @Column(name = "is_deleted")
    private Boolean isDeleted = false;

    @Column(name = "url_img", nullable = false)
    private String urlImg;

    public enum VehicleStatus {
        ACTIVATE,
        MAINTENANCE,
        DEACTIVATED
    }

    public enum VehicleType {
        STANDARD,
        SLEEPER,
        LIMOUSINE,
        PRIVATECABIN
    }

    @OneToMany(mappedBy = "car", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Maintenance> maintenanceList;

    @OneToMany(mappedBy = "car", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<VehicleAssignment> vehicleAssignmentList;
}
