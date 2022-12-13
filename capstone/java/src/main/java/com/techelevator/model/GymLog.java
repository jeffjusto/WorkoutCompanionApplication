package com.techelevator.model;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

public class GymLog {

    private int logId;
    private int userId;
    private Date checkIn;
    private Date checkOut;
    private String difference;


    public GymLog() {
    }

    public GymLog(int logId, int userId, Timestamp checkIn, Timestamp checkOut, String difference) {
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

    public Timestamp getCheckIn() {
        Timestamp timestamp = new Timestamp(checkIn.getTime());
        return timestamp;
    }

    public void setCheckIn(Date checkIn) {
        this.checkIn = checkIn;
    }

    public Timestamp getCheckOut() {
        Timestamp timestamp = new Timestamp(checkOut.getTime());
        return timestamp;
    }

    public void setCheckOut(Timestamp checkOut) {
        this.checkOut = checkOut;
    }

    public String getDifference() {
        return difference;
    }

    public void setDifference(String difference) {
        String[] differenceArray = difference.split(" ");
//        difference = differenceArray[6] + " " + differenceArray[7] + " " + differenceArray[8] + " " + differenceArray[9];
        this.difference = differenceArray[0];
    }

    @Override
    public String toString() {
        return "GymLog{" +
                "logId=" + logId +
                ", userId=" + userId +
                ", checkIn=" + checkIn +
                ", checkOut=" + checkOut +
                ", difference='" + difference + '\'' +
                '}';
    }
}
