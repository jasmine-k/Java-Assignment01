package edu.knoldus.services;

import edu.knoldus.models.Trainee;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class TraineeScoreCalculationTest implements TraineeScoreCalculation{

    private String[] language = {"Scala", "Akka", "Play", "Java", "C++"};

    private double[] score1 = {60, 80, 90, 100, 20};
    private double[] score2 = {20, 100, 60, 10, 40};
    private double[] score3 = {70, 100, 70, 100, 100};
    private double[] score4 = {90, 90, 20, 50, 50};
    private double[] score5 = {40, 10, 30, 60, 70};
    private double[] score6 = {0, 0, 0, 0, 0};

    private Trainee trainee1 = new Trainee(1, "Jasmine", "Kaur", language, score1);
    private Trainee trainee2 = new Trainee(2, "Simran", "Kaur", language, score2);
    private Trainee trainee3 = new Trainee(3, "Ruby", "Sharma", language, score3);
    private Trainee trainee4 = new Trainee(4, "Ram", "Singh", language, score4);
    private Trainee trainee5 = new Trainee(5, "Jas", "Arora", language, score5);
    private Trainee trainee6 = new Trainee(6, "Jassu", "Arora", language, score6);

    private List<Trainee> listOfTrainee = Arrays.asList(trainee1, trainee2, trainee3, trainee4, trainee5);
    private List<Trainee> emptyListOfTrainee = Arrays.asList();

    @Test
    public void checkIfEligibleTest(){
        Boolean result = TraineeScoreCalculation.checkIfEligible(trainee3);
        assert (result == true);
    }

    @Test
    public void percentageCalculationTest(){
        double result = TraineeScoreCalculation.percentageCalculation(trainee3);
        assert (result == 88.0);
    }

    @Test
    public void percentageCalculationZeroSumCaseTest(){
        double result = TraineeScoreCalculation.percentageCalculation(trainee6);
        assert (result == 0.0);
    }

}