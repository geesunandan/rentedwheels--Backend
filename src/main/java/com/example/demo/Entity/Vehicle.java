package com.example.demo.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="vehicle")
public class Vehicle {
    @Id
    @GeneratedValue
    private int id;
    private String availability;
    private String model;
    private int rentalRate;
    private String type;
    private String usageType;
    private String vehicleName;
    private String vehicleNumber;
}
