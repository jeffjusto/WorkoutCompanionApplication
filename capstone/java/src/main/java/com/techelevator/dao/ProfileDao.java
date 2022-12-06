package com.techelevator.dao;

import com.techelevator.model.Profile;
import com.techelevator.model.User;

import java.util.List;

public interface ProfileDao {

    boolean createProfile(int profileID, int userID, String name, String email, List<String> goals);

    List<Profile> findAll();

}
