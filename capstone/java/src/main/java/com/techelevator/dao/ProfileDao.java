package com.techelevator.dao;

import com.techelevator.model.Profile;
import com.techelevator.model.User;

import java.util.List;

public interface ProfileDao {

    boolean createProfile(int userId);

    boolean updateProfile(Profile profile);

    boolean updateProfileImg(String profileImg, int userId);

    List<Profile> findAll();

    public Profile findProfileById(int userId);

}
