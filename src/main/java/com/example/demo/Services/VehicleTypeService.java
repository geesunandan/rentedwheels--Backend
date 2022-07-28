package com.example.demo.Services;

import com.example.demo.Entity.Vehicle;
import com.example.demo.Entity.VehicleType;
import com.example.demo.Repository.VehicleRepository;
import com.example.demo.Repository.VehicleTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class VehicleTypeService {
    @Autowired
    VehicleTypeRepository vehicleTypeRepository;

    //Gives vehicles type list
    public List<VehicleType> getAllVehicles(){
        return vehicleTypeRepository.findAll();
    }

    //Saves Vehicle
    public  VehicleType saveVehicle(VehicleType vehicleType){
        return (VehicleType) vehicleTypeRepository.save(vehicleType);
    }

    //Finding the vehicle
    public VehicleType getById(int id){
        return (VehicleType) vehicleTypeRepository.findById(id).orElse(null);
    }
}

