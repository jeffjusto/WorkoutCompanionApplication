package com.techelevator.dao;

import com.techelevator.model.Profile;
import com.techelevator.model.User;

import java.util.List;

public interface ProfileDao {

//    boolean createProfile(Profile profile);

    boolean createProfile(Profile profile, int user_id);

    List<Profile> findAll();

}
