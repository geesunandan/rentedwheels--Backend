package com.example.demo.Controller;

import com.example.demo.Entity.Vehicle;
import com.example.demo.Services.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class VehicleController {

    @Autowired
    VehicleService vehicleService;

    @PostMapping("/addWheel")
    public Vehicle addVehicle (@RequestBody Vehicle vehicle){
        return vehicleService.saveVehicle(vehicle);
    }

    @PostMapping("/addWheels")
    public List<Vehicle> addVehicles(@RequestBody List<Vehicle> vehicles){
        return vehicleService.saveVehicles(vehicles);
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
}
