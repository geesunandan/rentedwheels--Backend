package com.example.demo.Controller;

import com.example.demo.Entity.User;
import com.example.demo.Entity.Vehicle;
import com.example.demo.Entity.VehicleRatingDTO;
import com.example.demo.Services.UserService;
import com.example.demo.Services.VehicleRatingService;
import com.example.demo.Services.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class UserController {

    @Autowired
    UserService userService;
    @Autowired
    VehicleService vehicleService;
    @Autowired
    VehicleRatingService vehicleRatingService;

    private VehicleRatingDTO vehicleRatingDTO;

    @PostMapping("/addUser")
    public User saveUser(@RequestBody User user){
        return userService.saveUser(user);
    }

    @GetMapping("/getUser/{id}")
    public User getUser(@PathVariable int id){
        return userService.getById(id);
    }

    @GetMapping("/getUsers")
    public List<User> getUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("/getAdmins")
    public List<User> getAdmins(){return userService.getAllAdmin();}


    @PutMapping("/updateUser/{id}")
    public User updateUser(@RequestBody User user){
        return userService.updateUser(user);
    }

    @DeleteMapping("deleteUser/{id}")
    public User deleteUser(@PathVariable int id){
        return userService.deleteUser(id);
    }


    @PostMapping("rate/{userID}/{vehicleID}")
    public String rateVehicles(@PathVariable("userID") int userID,
                               @PathVariable("vehicleID") int vehicleID,
                               @RequestParam(value="comment",required=false) String comment,
                               @RequestParam(value="rating",required=false) Integer rating){
        vehicleRatingDTO = new VehicleRatingDTO();
        if(comment != null ){
            vehicleRatingDTO.setComment(comment);
        }
        if(rating != null && rating>0){
            vehicleRatingDTO.setRatings(rating);
        }
        if(rating ==null && comment == null){
            vehicleRatingDTO=null;
        }
        return vehicleRatingService.rateVehicle(userID, vehicleID, vehicleRatingDTO);

    }
}
