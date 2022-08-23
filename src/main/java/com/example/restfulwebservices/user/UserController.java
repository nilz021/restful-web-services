package com.example.restfulwebservices.user;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.restfulwebservices.exception.UserNotFoundException;
import com.example.restfulwebservices.exception.UserDataNullException;

@RestController
public class UserController {

    @Autowired
    public UserDaoServices service;
    
    @GetMapping("users")
    public List<User> getAllUsers(){
        return service.findAll();
    }

    @GetMapping("users/user/{id}")
    public User retrieveUser(@PathVariable int id){
        User foundUser = service.findOne(id);
        if(foundUser == null){
            throw new UserNotFoundException("id : " + id);
        }
        return foundUser;
    }

    //For post maethod use ARC client
    // copy below JSON in RequestBody
    /*{
        "name": "Nilesh",
        "birthaDate": "2022-08-15T12:24:06.567+00:00"
    }*/
    @PostMapping("users/user")
    public void createUser(@Valid @RequestBody User user){
        if(user.getName() == null){
            throw new UserDataNullException("name : " + user.getName());
        }
        if(user.getBirthaDate() == null){
            throw new UserDataNullException("birthDate : " + user.getBirthaDate());
        }

        service.save(user);
    }

    @DeleteMapping("users/user/{id}")
    public void deleteById(@PathVariable int id){
        service.removeUser(id);
    }
}
