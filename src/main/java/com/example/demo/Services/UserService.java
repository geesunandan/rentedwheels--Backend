package com.example.demo.Services;

import com.example.demo.Entity.User;
import com.example.demo.Entity.Vehicle;
import com.example.demo.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import javax.jws.soap.SOAPBinding;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    //Gives users list
    public List<User> getAllUsers(){
        List<User> userList= userRepository.findAll();
        List<User> newUserList= new ArrayList<>();
        for(User user: userList){
            if(!user.isDeleted()){
                newUserList.add(user);
            }
        }
        return newUserList;
        //return userRepository.findAll().stream().filter(x -> !x.isDeleted()).collect(Collectors.toList());
    }


    //Gives admin list
    public List<User> getAllAdmin(){
        List<User> adminList = userRepository.findAll();
        List<User> newAdminList= new ArrayList<>();
        for(User user: adminList){
            if(user.isAdmin()){
                newAdminList.add(user);
            }
        }
        return newAdminList;

    }

    //Saves User
    public  User saveUser(User user){
        return (User) userRepository.save(user);
    }

    //Finding the user
    public User getById(int id){
        return (User) userRepository.findById(id).orElse(null);
    }
//Update the user
    public User updateUser(User user) {
        User user1 = userRepository.findById(user.getId()).get();

        user1.setAddress(user.getAddress());
        user1.setCitizenshipAttachment(user.getCitizenshipAttachment());
        user1.setFullName(user.getFullName());
        user1.setEmailAddress(user.getEmailAddress());
        user1.setPassword(user.getPassword());
        user1.setPickupOutlet(user.getPickupOutlet());
        user1.setPhoneNumber(user.getPhoneNumber());
    return userRepository.save(user1);
    }

    //Deletes the user

    public User deleteUser(int id){
        User user = userRepository.findById(id).get();
        user.setDeleted(true);
        return userRepository.save(user);
    }






}
