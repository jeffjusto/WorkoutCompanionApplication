package com.techelevator.dao;

import com.techelevator.model.Profile;
import com.techelevator.model.User;

import java.util.List;

public interface ProfileDao {

    boolean createProfile(Profile profile);

    List<Profile> findAll();

}
