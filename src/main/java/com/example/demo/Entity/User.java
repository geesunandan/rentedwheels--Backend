package com.example.demo.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name ="user")
public class User {
    @Id
    @GeneratedValue( strategy = GenerationType.AUTO)

    private int id;
    private String address;
    private String emailAddress;
    private String fullName;
    private String password;
    private String phoneNumber;
    private String pickupOutlet;
    private String citizenshipAttachment;
    private boolean admin;
    private boolean deleted;

}
