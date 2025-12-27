package com.airtribe.learntrack.entity;


public class Trainer extends Person {

    private String expertise;
    private boolean active;

    // Default constructor
    public Trainer() {
        this.active = true;
    }

    // Parameterized constructor
    public Trainer(int id, String firstName, String lastName, String email, String expertise) {
        super(id, firstName, lastName, email); // use of super
        this.expertise = expertise;
        this.active = true;
    }

    // Getters & Setters

    public String getExpertise() {
        return expertise;
    }

    public void setExpertise(String expertise) {
        this.expertise = expertise;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    // Method overriding (polymorphism)
    @Override
    public String getDisplayName() {
        return "Trainer: " + getFirstName() + " " + getLastName()
                + " | Expertise: " + expertise;
    }
}
