package com.techelevator.controller;

import com.techelevator.dao.UserDao;
import com.techelevator.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class UserController {

    @Autowired
    UserDao users;

    @RequestMapping(path = "/allUsers" , method = RequestMethod.GET)
    public List<User> listUsers(){
        List<User> allUsers = users.findAll(); //Get all registered users

        return allUsers; //return the users
    }
}
