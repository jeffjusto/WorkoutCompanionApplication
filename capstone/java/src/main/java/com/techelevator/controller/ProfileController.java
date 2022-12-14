package com.techelevator.controller;


import com.techelevator.dao.JdbcProfileDao;
import com.techelevator.dao.ProfileDao;
import com.techelevator.model.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
public class ProfileController {

    private JdbcProfileDao dao;
    public ProfileController(JdbcProfileDao dao) {
        this.dao = dao;
    }

    @RequestMapping(path = "/profiles", method = RequestMethod.GET)
    public List<Profile> findAllProfiles() {
        List<Profile> profiles = new ArrayList<>();
        try {
            profiles= dao.findAll();
        } catch (Exception e) {
            System.out.println(e.getMessage() + "RequestMapping");
        }
        return profiles;
    }

    @RequestMapping(path = "/profiles/{userId}", method = RequestMethod.GET)
    public Profile findProfileById(@PathVariable int userId) {
        Profile profile = new Profile();
        try {
            profile = dao.findProfileById(userId);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return profile;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path = "/profiles/{user_id}", method = RequestMethod.POST)
    public boolean createProfile(@RequestBody Profile profile, @PathVariable int userId) {
        try {
            dao.createProfile(userId);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return true;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path = "/profiles/{user_id}", method = RequestMethod.PUT)
    public boolean updateProfile(@RequestBody Profile profile) {
        try {
            dao.updateProfile(profile);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return true;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path = "/profiles/img/{userId}", method = RequestMethod.PUT)
    public boolean updateProfileImg(@RequestBody Profile profile) {
        try {
            dao.updateProfileImg(profile.getProfileImg(), profile.getUserId());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return true;
    }
}
