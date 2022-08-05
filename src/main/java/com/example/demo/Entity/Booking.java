package com.example.demo.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name ="bookings")

public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private int id;
    @OneToOne
    @JoinColumn(name = "user", referencedColumnName = "id")
    private User bookedBy;

    @OneToOne
    @JoinColumn(name = "vehicle", referencedColumnName = "id")
    private Vehicle vehicle;

    private boolean booked;


}
