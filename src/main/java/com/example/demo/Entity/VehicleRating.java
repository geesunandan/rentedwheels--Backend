package com.example.demo.Entity;

import lombok.*;
import org.springframework.lang.Nullable;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name ="vehicleRating")
public class VehicleRating {

    @Id
    @GeneratedValue( strategy = GenerationType.AUTO)
    private int id;

    @JoinColumn
    @ManyToOne
    private Vehicle vehicle;

    @JoinColumn
    @ManyToOne
    private User user;

    //Maximum of 5
    
    private int rating;

    //Comment
    private String comment;
}
