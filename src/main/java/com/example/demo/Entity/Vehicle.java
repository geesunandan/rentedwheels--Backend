package com.example.demo.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name ="vehicle")
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private boolean booked;
//    private String model;
//    private int rentalRate;
//    private String type;
//    private String usageType;
    private String vehicleName;
    private String vehicleType;
    private String vehicleRating;
    private String vehicleReview;
    private int vehiclePrice;
//    private String vehicleNumber;
}
