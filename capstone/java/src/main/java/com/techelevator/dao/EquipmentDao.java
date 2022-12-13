package com.techelevator.dao;

import com.techelevator.model.Equipment;

import java.util.List;

public interface EquipmentDao {

    List<Equipment> listAll();

    String getInstructionByEquipmentId(int id);

}
