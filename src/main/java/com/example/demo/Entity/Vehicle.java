package com.example.demo.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name ="vehicle")
@Builder
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private boolean booked;
    private String fuelElectric;
    private String ac;
    private String type;
    private String seats;
    private String vehicleName;
    private String vehicleType;
    private String vehicleRating;
    private String vehicleReview;
    private int vehiclePrice;
    private String vehicleNumber;
    private String autoManual;
    private String maxPower;
    private String topSpeed;
    private String vehicleImage;
    private String accelerationTime;
    private String filePath;

}
