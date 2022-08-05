package com.example.demo.Services;

import com.example.demo.Entity.Booking;
import com.example.demo.Entity.User;
import com.example.demo.Entity.Vehicle;
import com.example.demo.Repository.BookingRepository;
import com.example.demo.Repository.UserRepository;
import com.example.demo.Repository.VehicleTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookingService {
    @Autowired
    BookingRepository bookingRepository;

    @Autowired
    UserService userService;

    @Autowired
    VehicleService vehicleService;
//    UserRepository userRepository;
//    VehicleTypeRepository vehicleTypeRepository;

    //Gives Booking list
    public List<Booking> getAllBookings(){
        List<Booking> bookingList= bookingRepository.findAll();
        List<Booking> newBookingList= new ArrayList<>();
        return newBookingList;
         }


    //Saves Booking
    public  Booking saveBookingName(int userId, int vehicleId){
        Booking booking = new Booking();
        Vehicle vechile= vehicleService.getById(vehicleId);
        User user = userService.getById(userId);
        booking.setVehicle(vechile);
        booking.setBookedBy(user);
        booking.setBooked(true);
        return bookingRepository.save(booking);
    }

    //Finding the booking
    public Booking getById(int id){
        return (Booking) bookingRepository.findById(id).orElse(null);
    }
    //Update the booking
    public Booking updateBooking(Booking booking) {
        Booking booking1 = bookingRepository.findById(booking.getId()).get();

        booking1.setBookedBy(booking.getBookedBy());

        return bookingRepository.save(booking1);
    }


}
