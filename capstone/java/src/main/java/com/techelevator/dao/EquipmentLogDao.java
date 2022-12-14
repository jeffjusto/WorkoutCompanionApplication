package com.techelevator.dao;

import com.techelevator.model.EquipmentLog;
import com.techelevator.model.GymLog;

import java.util.List;

public interface EquipmentLogDao {

    public void createEntry(EquipmentLog equipmentLog);

    public List<EquipmentLog> getEntriesByUserId(int userId);

}
