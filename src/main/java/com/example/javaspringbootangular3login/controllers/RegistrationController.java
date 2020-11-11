package com.example.javaspringbootangular3login.controllers;

import com.example.javaspringbootangular3login.models.User;
import com.example.javaspringbootangular3login.services.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RegistrationController {

    @Autowired
    RegistrationService service;

    @GetMapping("/findAll")
    public List<User> findAllUser(){
        return service.findAll();
    }

    @PostMapping("/save")
    public User save(@RequestBody User user){
        return service.saveUser(user);
    }

    @PostMapping("/register")
    @CrossOrigin("http://localhost:4200/register")
    public User saveUser(@RequestBody  User user) throws Exception {
        String email = user.getEmail();
        System.out.println("email : "+user.getEmail());
        User u1 = null;
        u1 = service.findByEmail(email);
        if(!email.isEmpty() && u1!=null && email.equals(u1.getEmail())){
            throw new Exception("This Email was used!!");
        }
        return service.saveUser(user);
    }
    @PostMapping("/login")
    @CrossOrigin("http://localhost:4200")
    public User loginUser(@RequestBody User user) throws Exception {
        String tempEmail = user.getEmail();
        String tempPassword = user.getPassword();
        User user1 = null;
        if(tempEmail != null && tempPassword != null){
            user1 = service.findByEmailAndPassword(tempEmail,tempPassword);
        }
        if(user1==null){
            throw new Exception("Email or Password Was Wrong");
        }
        return user1;
    }
}
