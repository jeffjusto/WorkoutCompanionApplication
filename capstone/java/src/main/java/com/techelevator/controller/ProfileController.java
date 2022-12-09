package com.techelevator.controller;


import com.techelevator.dao.ProfileDao;
import com.techelevator.model.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin

public class ProfileController {

    private ProfileDao profileDao;

    final String API = "http://localhost:9000";

    public ProfileController(ProfileDao profileDao) {
        this.profileDao = profileDao;
    }

    @RequestMapping(path = "/profiles", method = RequestMethod.GET)
    public List<Profile> findAllProfiles() {
        List<Profile> profiles = new ArrayList<>();
        try {
            profiles= profileDao.findAll();
        } catch (Exception e) {
            System.out.println(e.getMessage() + "RequestMapping");
        }
        return profiles;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path = "/profiles/{user_id}", method = RequestMethod.POST)
    public boolean createProfile(@RequestBody Profile profile, @PathVariable int userId) {
        try {
            profileDao.createProfile(userId);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return true;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path = "/profiles", method = RequestMethod.PUT)
    public boolean updateProfile(@RequestBody Profile profile) {
        try {
            profileDao.updateProfile(profile);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return true;
    }
}
