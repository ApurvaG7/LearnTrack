package com.airtribe.learntrack.entity;

import com.airtribe.learntrack.enums.CourseStatus;


public class Course {

    private int id;
    private String courseName;
    private String description;
    private int durationInWeeks;
    private int trainerId;
    private boolean active;
    private CourseStatus status;

    // Default constructor
    public Course() {
        this.active = true;
        this.status = CourseStatus.ACTIVE;
    }

    // Parameterized constructor
    public Course(int id, String courseName, String description, int durationInWeeks, int trainerId) {
        this.id = id;
        this.courseName = courseName;
        this.description = description;
        this.durationInWeeks = durationInWeeks;
        this.trainerId = trainerId;
        this.active = true;
    }


    // Getters & Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getDurationInWeeks() {
        return durationInWeeks;
    }

    public void setDurationInWeeks(int durationInWeeks) {
        this.durationInWeeks = durationInWeeks;
    }

    public int getTrainerId() {
        return trainerId;
    }

    public void setTrainerId(int trainerId) {
        this.trainerId = trainerId;
    }


    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public CourseStatus getStatus() {
        return status;
    }

    public void setStatus(CourseStatus status) {
        this.status = status;
    }
}
