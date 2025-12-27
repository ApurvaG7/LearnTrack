package com.airtribe.learntrack.entity;


public class Student extends Person {

    private String batch;
    private boolean active;

    // Default constructor
    public Student() {
        this.active = true;
    }

    // Constructor WITHOUT email (constructor overloading)
    public Student(int id, String firstName, String lastName, String batch) {
        super(id, firstName, lastName, null);
        this.batch = batch;
        this.active = true;
    }

    // Constructor WITH email (constructor overloading)
    public Student(int id, String firstName, String lastName, String email, String batch) {
        super(id, firstName, lastName, email);
        this.batch = batch;
        this.active = true;
    }

    // Getters & Setters

    public String getBatch() {
        return batch;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    // Polymorphism: method overriding
    @Override
    public String getDisplayName() {
        return "Student: " + getFirstName() + " " + getLastName();
    }
}
