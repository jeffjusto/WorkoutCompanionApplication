package com.techelevator.model;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

public class GymLog {

    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");

    private int logId;
    private int userId;
    private Date checkIn;
    private Date checkOut;

    public GymLog() {
    }

    public GymLog(int logId, int userId, Timestamp checkIn, Timestamp checkOut) {
        this.logId = logId;
        this.userId = userId;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
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

    @Override
    public String toString() {
        return "GymLog{" +
                "logId=" + logId +
                ", userId=" + userId +
                ", checkIn=" + checkIn +
                ", checkOut=" + checkOut +
                '}';
    }

}














