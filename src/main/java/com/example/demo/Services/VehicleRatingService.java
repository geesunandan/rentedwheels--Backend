package com.example.demo.Services;

import com.example.demo.Entity.User;
import com.example.demo.Entity.Vehicle;
import com.example.demo.Entity.VehicleRating;
import com.example.demo.Entity.VehicleRatingDTO;
import com.example.demo.Repository.VehicleRatingRepository;
import com.example.demo.Repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VehicleRatingService {

    @Autowired
    private VehicleService vehicleService;
    @Autowired
    private UserService userService;
    @Autowired
    private VehicleRatingRepository vehicleRatingRepository;
    @Autowired
    private VehicleRepository vehicleRepository;

    public String rateVehicle(int userID, int vehicleID, VehicleRatingDTO dto){

        VehicleRating rating = new VehicleRating();
        Vehicle vehicle= vehicleService.getById(vehicleID);
        User user = userService.getById(userID);

        if(vehicle ==null){
            return "Vehicle Not Found";
        }
        if(user ==null){
            return "User Not Found";
        }
        if(dto==null){
            return "Thank you Visit Again";
        }
        if(dto.getComment() != null){
            rating.setComment(dto.getComment());
        }

        if(dto.getRatings()<6 || dto.getRatings() >0){
            rating.setRating(dto.getRatings());
        }

        rating.setVehicle(vehicle);
        rating.setUser(user);
        vehicleRatingRepository.save(rating);
        return "Rated";

    }
}
