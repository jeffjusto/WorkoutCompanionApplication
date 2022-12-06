package com.techelevator.model;

import java.util.List;

public class Profile {

    private int profileID;
    private int userID;
    private String name;
    private String email;
    //TODO Add Profile Picture
    private List<String> goals;

    public Profile(int profileID, int userID, String name, String email, List<String> goals) {
        this.profileID = profileID;
        this.userID = userID;
        this.name = name;
        this.email = email;
        this.goals = goals;
    }

    public int getProfileID() {
        return profileID;
    }

    public void setProfileID(int profileID) {
        this.profileID = profileID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<String> getGoal() {
        return goals;
    }

    public void setGoal(List<String> goals) {
        this.goals = goals;
    }

    @Override
    public String toString() {
        return "Profile{" +
                "profileID=" + profileID +
                ", userID=" + userID +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", goal='" + goals + '\'' +
                '}';
    }




}
