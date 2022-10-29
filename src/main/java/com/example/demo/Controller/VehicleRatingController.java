package com.example.demo.Controller;

import com.example.demo.Entity.VehicleRating;
import com.example.demo.Entity.VehicleRatingDTO;
import com.example.demo.Services.VehicleRatingService;
import com.example.demo.Services.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class VehicleRatingController {

    @Autowired
    private VehicleRatingService vehicleRatingService;


    @GetMapping("ratings/{vehicleID}")
    public List<VehicleRatingDTO> findRatingAndCommentsByVehicle(@PathVariable int vehicleID) throws Exception {
        return vehicleRatingService.findRatingDetailsByVehicle(vehicleID);
    }
}
