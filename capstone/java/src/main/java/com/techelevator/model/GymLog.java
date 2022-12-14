package com.techelevator.model;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

public class GymLog {

    private int logId;
    private int userId;
    private Date checkIn;
    private Date checkOut;
    private int difference;


    public GymLog() {
    }

    public GymLog(int logId, int userId, Timestamp checkIn, Timestamp checkOut, int difference) {
        this.logId = logId;
        this.userId = userId;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.difference = difference;
    }

    public int getLogId() {
        return logId;
    }

    public void setLogId(int logId) {
        this.logId = logId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Date getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(Date checkIn) {
        this.checkIn = checkIn;
    }

    public Date getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(Date checkOut) {
        this.checkOut = checkOut;
    }

    public int getDifference() {
        return difference;
    }

    public void setDifference(int difference) {
        this.difference = difference;
    }

    @Override
    public String toString() {
        return "GymLog{" +
                "logId=" + logId +
                ", userId=" + userId +
                ", checkIn=" + checkIn +
                ", checkOut=" + checkOut +
                ", difference=" + difference +
                '}';
    }
}
