package com.techelevator.model;

import java.util.List;

public class Profile {

    private int profileId;
    private int userId;
    private String name;
    private String email;
    private String goals;
    private String profileImg;

    public Profile() {
    }

    public Profile(int profileId, int userId, String name, String email, String goals, String profileImg) {
        this.profileId = profileId;
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.goals = goals;
        this.profileImg = profileImg;
    }

    public int getProfileId() {
        return profileId;
    }

    public void setProfileId(int profileId) {
        this.profileId = profileId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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

    public String getProfileImg() {
        return profileImg;
    }

    public void setProfileImg(String profileImg) {
        this.profileImg = profileImg;
    }

    @Override
    public String toString() {
        return "Profile{" +
                "profileId=" + profileId +
                ", userId=" + userId +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", goals='" + goals + '\'' +
                ", profileImg='" + profileImg + '\'' +
                '}';
    }
}
