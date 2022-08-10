package com.example.demo.Controller;

import com.example.demo.Entity.Booking;
import com.example.demo.Entity.Vehicle;
import com.example.demo.Services.BookingService;
import com.example.demo.Services.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class VehicleController {

    @Autowired
    VehicleService vehicleService;

    @Autowired
    BookingService bookingService;

    @PostMapping("/addWheel")
    public Vehicle addVehicle (@RequestBody Vehicle vehicle){
        return vehicleService.saveVehicle(vehicle);
    }

    @PostMapping("/addWheels")
    public List<Vehicle> addVehicles(@RequestBody List<Vehicle> vehicles){
        return vehicleService.saveVehicles(vehicles);
    }

    // New
    @PostMapping("/bookVehicle")
    public Vehicle bookVehicle(@PathVariable int id){
        return vehicleService.bookingStatus(id);
    }

    //End of post mapping

    @GetMapping("/getVehicles")
    public List<Vehicle> getVehicles(){
        return vehicleService.getAllVehicles();
    }

    @GetMapping("/getVehicle/{id}")
    public Vehicle getVehicleById(@PathVariable int id){
        return vehicleService.getById(id);
    }

    @GetMapping("/getOffroad/{vehicleType}")
    public List<Vehicle> getOffroad(@PathVariable String vehicleType){return vehicleService.getOffroads(vehicleType);}
//End of get request

    //Start of Put Request
    @PutMapping("/updateVehicle")
    public Vehicle updateVehicle(@RequestBody Vehicle vehicle) {
        return vehicleService.updateVehicle(vehicle);
    }

    //Delete using delete request
    @DeleteMapping("/deleteVehicle/{id}")
    public String deleteVehicle(@PathVariable int id){ return vehicleService.deleteVehicle(id);}

// For the id method mentioned above

//    @PostMapping("/{userId}/{vehicleId}")
//    public Booking bookingVehicle(@PathVariable int userId, @PathVariable int vehicleId){
//        return bookingService.saveBookingName(userId, vehicleId);
//    }
}
