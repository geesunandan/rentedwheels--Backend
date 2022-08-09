package com.example.demo.Services;

import com.example.demo.Entity.Booking;
import com.example.demo.Entity.User;
import com.example.demo.Entity.Vehicle;
import com.example.demo.Repository.BookingRepository;
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

         //Below code was for case when the entity id from one table were drawn for the booking table

//    //Saves Booking
//    public  Booking saveBookingName(int userId, int vehicleId){
//        Booking booking = new Booking();
//        Vehicle vechile= vehicleService.getById(vehicleId);
//        User user = userService.getById(userId);
//        booking.setVehicle(vechile);
//        booking.setBookedBy(user);
//        booking.setBooked(true);
//        return bookingRepository.save(booking);
//    }
//
//    //Finding the booking
//    public Booking getById(int id){
//        return (Booking) bookingRepository.findById(id).orElse(null);
//    }
//    //Update the booking
//    public Booking updateBooking(Booking booking) {
//        Booking booking1 = bookingRepository.findById(booking.getId()).get();
//
//        booking1.setBookedBy(booking.getBookedBy());
//
//        return bookingRepository.save(booking1);
//    }

//This is the new code for booking service i.e. getting info from the user again

    //Saves Booking
    public  Booking saveBooking(Booking booking){
        return (Booking) bookingRepository.save(booking);
    }

    //Finding the booking
    public Booking getById(int id){
        return (Booking) bookingRepository.findById(id).orElse(null);
    }
    //Update the booking
    public Booking updateBooking(Booking booking) {
        Booking booking1 = bookingRepository.findById(booking.getId()).get();

        booking1.setCity(booking.getCity());
        booking1.setFirstName(booking.getFirstName());
        booking1.setLastName(booking.getLastName());
        booking1.setFromDate(booking.getFromDate());
        booking1.setToDate(booking.getToDate());
        booking1.setMailAddress(booking.getMailAddress());
        booking1.setPhNumber(booking.getPhNumber());
        booking1.setZipCode(booking.getZipCode());
        return bookingRepository.save(booking1);
    }

    //Deletes the user

    public Booking deleteBooking(int id){
        Booking booking = bookingRepository.findById(id).get();
        booking.setBookingDeleted(true);
        return bookingRepository.save(booking);
    }


}
