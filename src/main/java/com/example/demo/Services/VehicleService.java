package com.example.demo.Services;

import com.example.demo.Entity.User;
import com.example.demo.Entity.Vehicle;
import com.example.demo.Repository.UserRepository;
import com.example.demo.Repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VehicleService {
    @Autowired
    VehicleRepository vehicleRepository;

    //Gives vehicles list
    public List<Vehicle> getAllVehicles(){
        return vehicleRepository.findAll();
    }

    //Saves Vehicle
    public  Vehicle saveVehicle(Vehicle vehicle){
        return (Vehicle) vehicleRepository.save(vehicle);
    }

    //Saves multiple vehicles at once
    public List<Vehicle> saveVehicles(List<Vehicle> vehicles) {

        return vehicleRepository.saveAll(vehicles);
    }

    //Finding the vehicle
    public Vehicle getById(int id){
        return (Vehicle) vehicleRepository.findById(id).orElse(null);

    }

    public List<Vehicle> getOffroads(String vehicleType){
        List<Vehicle> offroadList = vehicleRepository.findAll();
        List<Vehicle> newOffroadList= new ArrayList<>();
        for(Vehicle vehicle: offroadList){
            System.out.println("vehicle = " + vehicle);
            if(vehicle.getVehicleType().equalsIgnoreCase(vehicleType)){
                newOffroadList.add(vehicle);
            }
        }
        return newOffroadList;

    }




    //Updating the vehicle
    public  Vehicle updateVehicle(Vehicle vehicle){
        Vehicle vehicle1 = vehicleRepository.findById(vehicle.getId()).get();

        vehicle1.setVehicleName(vehicle.getVehicleName());
        vehicle1.setVehiclePrice(vehicle.getVehiclePrice());
        vehicle1.setVehicleType(vehicle.getVehicleType());
        vehicle1.setVehicleRating(vehicle.getVehicleRating());
        vehicle1.setVehicleReview(vehicle.getVehicleReview());



    return (Vehicle) vehicleRepository.save(vehicle1);
    }

    //Deleting the vehicle
    public String deleteVehicle(int id){
        vehicleRepository.deleteById(id);
        return "Vehicle removed " + id;
    }


}
