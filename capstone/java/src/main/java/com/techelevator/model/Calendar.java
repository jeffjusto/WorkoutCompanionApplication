package com.techelevator.model;

public class Calendar {

    private int eventId;
    private String classDate;
    private String classTime;
    private String instructor;
    private String className;
    private String classDescription;

    public Calendar(){

    }

    public Calendar(int eventId, String classDate, String classTime, String instructor, String className, String classDescription) {
        this.eventId = eventId;
        this.classDate = classDate;
        this.classTime = classTime;
        this.instructor = instructor;
        this.className = className;
        this.classDescription = classDescription;
    }

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public String getClassDate() {
        return classDate;
    }

    public void setClassDate(String classDate) {
        this.classDate = classDate;
    }

    public String getClassTime() {
        return classTime;
    }

    public void setClassTime(String classTime) {
        this.classTime = classTime;
    }

    public String getInstructor() {
        return instructor;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getClassDescription() {
        return classDescription;
    }

    public void setClassDescription(String classDescription) {
        this.classDescription = classDescription;
    }
}
