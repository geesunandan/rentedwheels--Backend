package com.example.demo.Controller;

import com.example.demo.Entity.User;
import com.example.demo.Entity.Vehicle;
import com.example.demo.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class UserController {
@Autowired
    UserService userService;

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
}
