package edu.knoldus.models;

import static org.junit.Assert.*;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class TraineeTest {

    private String[] language = {"Scala", "Akka", "Play", "Java", "C++"};
    private double[] score1 = {60, 80, 90, 100, 20};
    private Trainee trainee1 = new Trainee(1, "Jasmine", "Kaur", language, score1);

    @Test
    public void getIdTest() {
        int id = trainee1.getId();
        assertEquals(1, id);
    }

    @Test
    public void getFirstTest() {
        String firstName = trainee1.getFirstName();
        assertEquals("Jasmine", firstName);
    }

    @Test
    public void getLastNameTest() {
        String lastName = trainee1.getLastName();
        assertEquals("Kaur", lastName);
    }

    @Test
    public void getLanguageTest() {
        String[] languageArray = trainee1.getLanguage();
        assert (language == languageArray);
    }

    @Test
    public void getScoreTest() {
        double[] scoreArray = trainee1.getScore();
        assert (score1 == scoreArray);
    }


}