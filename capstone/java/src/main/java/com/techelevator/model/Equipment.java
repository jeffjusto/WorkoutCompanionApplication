package com.techelevator.model;

public class Equipment {

    private int id;
    private String name;
    private String description;
    private String imgSrc;
    private String instructionSrc;

    public Equipment() {}

    public Equipment(int id, String name, String description, String imgSrc, String instructionSrc) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.imgSrc = imgSrc;
        this.instructionSrc = instructionSrc;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImgSrc() {
        return imgSrc;
    }

    public void setImgSrc(String imgSrc) {
        this.imgSrc = imgSrc;
    }

    public String getInstructionSrc() {
        return instructionSrc;
    }

    public void setInstructionSrc(String instructionSrc) {
        this.instructionSrc = instructionSrc;
    }

    @Override
    public String toString() {
        return "Equipment{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", imgSrc='" + imgSrc + '\'' +
                ", instructionSrc='" + instructionSrc + '\'' +
                '}';
    }
}
