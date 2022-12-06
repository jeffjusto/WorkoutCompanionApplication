package com.techelevator.model;

import java.util.List;

public class Profile {

    private int profileid;
    private int userid;
    private String name;
    private String email;
    //TODO Add Profile Picture
    private String goals;

    public Profile() {
    }

    public Profile(int profileid, int userid, String name, String email, String goals) {
        this.profileid = profileid;
        this.userid = userid;
        this.name = name;
        this.email = email;
        this.goals = goals;
    }

    public int getProfileid() {
        return profileid;
    }

    public void setProfileid(int profileid) {
        this.profileid = profileid;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
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
                "profileid=" + profileid +
                ", userid=" + userid +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", goals='" + goals + '\'' +
                '}';
    }
}
