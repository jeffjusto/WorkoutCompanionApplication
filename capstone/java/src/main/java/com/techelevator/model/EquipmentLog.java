package com.techelevator.model;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;

public class EquipmentLog {

    private int entryId;
    private int userId;
    private int equipmentId;
    private Date equipmentCheckIn;
    private Date equipmentCheckOut;
    private int equipmentTimeInterval;
    private int weight;
    private int reps;


    public EquipmentLog() {

    }


    public EquipmentLog(int entryId, int userId, int equipmentId, Date equipmentCheckIn, Date equipmentCheckOut, int equipmentTimeInterval, int weight, int reps) {
        this.entryId = entryId;
        this.userId = userId;
        this.equipmentId = equipmentId;
        this.equipmentCheckIn = equipmentCheckIn;
        this.equipmentCheckOut = equipmentCheckOut;
        this.equipmentTimeInterval = equipmentTimeInterval;
        this.weight = weight;
        this.reps = reps;
    }

    public int getEntryId() {
        return entryId;
    }

    public void setEntryId(int entryId) {
        this.entryId = entryId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getEquipmentId() {
        return equipmentId;
    }

    public void setEquipmentId(int equipmentId) {
        this.equipmentId = equipmentId;
    }

    public Date getEquipmentCheckIn() {
        return equipmentCheckIn;
    }

    public void setEquipmentCheckIn(Date equipmentCheckIn) {
        this.equipmentCheckIn = equipmentCheckIn;
    }

    public Date getEquipmentCheckOut() {
        return equipmentCheckOut;
    }

    public void setEquipmentCheckOut(Date equipmentCheckOut) {
        this.equipmentCheckOut = equipmentCheckOut;
    }

    public int getEquipmentTimeInterval() {
        return equipmentTimeInterval;
    }

    public int setEquipmentTimeInterval(int equipmentTimeInterval) {
        return this.equipmentTimeInterval = equipmentTimeInterval;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getReps() {
        return reps;
    }

    public void setReps(int reps) {
        this.reps = reps;
    }

}
