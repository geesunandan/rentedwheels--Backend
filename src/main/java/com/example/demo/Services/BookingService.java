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

    // userService and vehicleService objects were made for the case where booking table draws id of vehicle and user
//not applicable right now so ignore

    @Autowired
    UserService userService;

    @Autowired
    VehicleService vehicleService;

    //Gives Booking list
    public List<Booking> getAllBookings(){
        List<Booking> bookingList= bookingRepository.findAll();
        List<Booking> newBookingList= new ArrayList<>();
        for(Booking booking: bookingList){
            if(!booking.isBookingDeleted()){
                newBookingList.add(booking);
            }
        }
        return newBookingList;
         }

         //Below code was for case when the entity id from one table were drawn for the booking table

//    //Saves Booking
    public  Booking saveBookingName(Booking booking, int userId, int vehicleId){ // int userId is also added inside paranthesis incase user needs to be saved
        Vehicle vehicle= vehicleService.getById(vehicleId);
        User user = userService.getById(userId);
        booking.setBookedBy(user);
        booking.setVehicle(vehicle);
        booking.setBooked(true);
        return bookingRepository.save(booking);
    }
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
    public  Booking saveBooking(Booking booking, int userId, int vehicleId){
           return saveBookingName(booking,userId, vehicleId);
    }

    //Finding the booking
    public Booking getBooking(int id){
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
        booking1.setVName(booking.getVName());
        booking1.setVprice(booking.getVprice());
        booking1.setVImage(booking.getVImage());
        booking1.setDestination(booking.getDestination());
        booking1.setCitizenshipAttachment(booking.getCitizenshipAttachment());
        return bookingRepository.save(booking1);
    }

    //Deletes the booking

    public Booking deleteBooking(int id){
        Booking booking = bookingRepository.findById(id).get();
        booking.setBookingDeleted(true);
        return bookingRepository.save(booking);
    }




}
