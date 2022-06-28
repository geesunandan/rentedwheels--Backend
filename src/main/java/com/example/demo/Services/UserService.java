package com.example.demo.Services;

import com.example.demo.Entity.User;
import com.example.demo.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.jws.soap.SOAPBinding;
import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    //Saves User
    public  User saveUser(User user){
        return (User) userRepository.save(user);
    }

    //Finding the user
    public User getById(int id){
        return (User) userRepository.findById(id).orElse(null);
    }
}
