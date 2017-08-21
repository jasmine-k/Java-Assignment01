package edu.knoldus.models;

public class Trainee {

    int id;
    String firstName;
    String lastName;
    String[] language;
    double[] score;

    public Trainee(int id, String firstName, String lastName, String[] language, double[] score) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.language = language;
        this.score = score;
    }

    public Trainee(int id) {
        this.id = id;
        this.firstName = "";
        this.lastName = "";
        this.language = new String[0];
        this.score = new double[0];
    }

    public int getId() {
        return this.id;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() { return lastName; }

    public String[] getLanguage() {
        return this.language;
    }

    public double[] getScore() {
        return this.score;
    }

    public void displayName() {
        System.out.println(this.firstName + " " + this.lastName);
    }

}


