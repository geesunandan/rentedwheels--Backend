package com.example.demo.Controller;

import com.example.demo.Entity.Booking;
import com.example.demo.Entity.Vehicle;
import com.example.demo.Services.BookingService;
import com.example.demo.Services.VehicleRatingService;
import com.example.demo.Services.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController

@CrossOrigin(origins = "http://localhost:3000")

public class VehicleController {

    @Autowired
    VehicleService vehicleService;

    @Autowired
    BookingService bookingService;

    @Autowired
    VehicleRatingService vehicleRatingService;

    //Adds vehicle
    @PostMapping("/addWheel")
    public Vehicle addVehicle (@RequestBody Vehicle vehicle){
        return vehicleService.saveVehicle(vehicle);
    }

    //Adds vehicle in list
    @PostMapping("/addWheels")
    public List<Vehicle> addVehicles(@RequestBody List<Vehicle> vehicles){
        return vehicleService.saveVehicles(vehicles);
    }

    // Books the vehicle
    @PostMapping("/bookVehicle")
    public Vehicle bookVehicle(@PathVariable int id){
        return vehicleService.bookingStatus(id);
    }

    //End of post mapping

  //Gets vehicles list
    @GetMapping("/getVehicles")
    public List<Vehicle> getVehicles(){
        return vehicleService.getAllVehicles();
    }

    //Gets a vehicle
    @GetMapping("/getVehicle/{id}")
    public Vehicle getVehicleById(@PathVariable int id){
        return vehicleService.getById(id);
    }

    //Gets a vehicle of offroad type
    @GetMapping("/getOffroad/{vehicleType}")
    public List<Vehicle> getOffroad(@PathVariable String vehicleType){return vehicleService.getOffroads(vehicleType);}
//End of get request

    //Start of Put Request

    // Updates the vehicle info
    @PutMapping("/updateVehicle")
    public Vehicle updateVehicle(@RequestBody Vehicle vehicle) {
        return vehicleService.updateVehicle(vehicle);
    }

    //Deletes the selected vehicle
    @DeleteMapping("/deleteVehicle/{id}")
    public String deleteVehicle(@PathVariable int id){ return vehicleService.deleteVehicle(id);}


    //Caluclating the average rating of vehicle
    @GetMapping("rating/{vehicleID}")
    public Double getVehicleRating(@PathVariable int vehicleID) throws Exception {
        return vehicleRatingService.findAverageRatingOFVehicle(vehicleID);
    }



// For the id method mentioned above

//    @PostMapping("/{userId}/{vehicleId}")
//    public Booking bookingVehicle(@PathVariable int userId, @PathVariable int vehicleId){
//        return bookingService.saveBookingName(userId, vehicleId);
//    }

}


