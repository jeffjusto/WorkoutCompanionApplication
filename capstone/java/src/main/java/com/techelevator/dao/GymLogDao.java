package com.techelevator.dao;

import com.techelevator.model.GymLog;

import java.util.List;

public interface GymLogDao {

    List<GymLog> getAll();

    List<GymLog> getAllById(int userId);

    void createGymLogEvent(GymLog gymLog);
}
