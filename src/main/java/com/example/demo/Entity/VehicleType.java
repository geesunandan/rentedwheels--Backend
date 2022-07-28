package com.example.demo.Entity;

import javax.persistence.*;

@Entity
@Table(name ="vehicle_type")
public class VehicleType {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private int id;
    private String type;


}
