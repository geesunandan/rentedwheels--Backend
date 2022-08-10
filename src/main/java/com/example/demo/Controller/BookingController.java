package com.example.demo.Controller;

import com.example.demo.Entity.Booking;
import com.example.demo.Services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookingController {
    @Autowired
    BookingService bookingService;

    @PostMapping("/addBooking")
  public Booking saveBooking(@RequestBody Booking booking){
        return bookingService.saveBooking(booking);
    }

    @GetMapping("/getBooking/{id}")
    public Booking getVehicleBooking(@PathVariable int id){
        return bookingService.getBooking(id);
    }

    @GetMapping("/getBookings")
    public List<Booking> getVehicleBooking(){
        return bookingService.getAllBookings();
    }


    @PutMapping("/updateBooking/{id}")
    public Booking updateBooking(@RequestBody Booking booking){
        return bookingService.updateBooking(booking);
    }

    @DeleteMapping("deleteBooking/{id}")
    public Booking deleteBooking(@PathVariable int id){
        return bookingService.deleteBooking(id);
    }



}
