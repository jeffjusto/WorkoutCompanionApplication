package com.techelevator.model;

import java.util.List;

public class Profile {

    private int profile_id;
    private int user_id;
    private String name;
    private String email;
    //TODO Add Profile Picture
    private String goals;

    public Profile() {
    }

    public Profile(int profile_id, int user_id, String name, String email, String goals) {
        this.profile_id = profile_id;
        this.user_id = user_id;
        this.name = name;
        this.email = email;
        this.goals = goals;
    }

    public int getProfileId() {
        return profile_id;
    }

    public void setProfileId(int profile_id) {
        this.profile_id = profile_id;
    }

    public int getUserId() {
        return user_id;
    }

    public void setUserId(int userid) {
        this.user_id = user_id;
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

    public String getGoals() {
        return goals;
    }

    public void setGoals(String goals) {
        this.goals = goals;
    }

    @Override
    public String toString() {
        return "Profile{" +
                "profileid=" + profile_id +
                ", userid=" + user_id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", goals='" + goals + '\'' +
                '}';
    }
}
