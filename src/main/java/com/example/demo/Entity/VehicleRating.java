package com.example.demo.Entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.util.Date;

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
    @CreationTimestamp
    public Date date;

}
