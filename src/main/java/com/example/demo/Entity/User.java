package com.example.demo.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="user")
public class User {
    @Id
    @GeneratedValue

    private int id;
    private String address;
    private String emailAddress;
    private String fullName;
    private String password;
    private int phoneNumber;
    private String pickupOutlet;
    private String citizenshipAttachment;

}
