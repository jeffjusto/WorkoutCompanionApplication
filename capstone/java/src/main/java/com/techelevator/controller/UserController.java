package com.techelevator.controller;

import com.techelevator.dao.UserDao;
import com.techelevator.model.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin

public class UserController {

    private UserDao userDao;

    UserController(UserDao userDao){
        this.userDao = userDao;
    }


}
