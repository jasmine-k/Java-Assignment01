package edu.knoldus.services;

import edu.knoldus.models.Trainee;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.*;

@RunWith(PowerMockRunner.class)
@PrepareForTest({TraineeScoreCalculation.class})
public class TraineeComparisonTest extends Mockito implements TraineeComparison{

    private String[] language = {"Scala", "Akka", "Play", "Java", "C++"};

    private double[] score1 = {60, 80, 90, 100, 20};
    private double[] score2 = {20, 100, 60, 10, 40};
    private double[] score3 = {70, 100, 70, 100, 100};
    private double[] score4 = {90, 90, 20, 50, 50};
    private double[] score5 = {40, 10, 30, 60, 70};

    private Trainee trainee1 = new Trainee(1, "Jasmine", "Kaur", language, score1);
    private Trainee trainee2 = new Trainee(2, "Simran", "Kaur", language, score2);
    private Trainee trainee3 = new Trainee(3, "Ruby", "Sharma", language, score3);
    private Trainee trainee4 = new Trainee(4, "Ram", "Singh", language, score4);
    private Trainee trainee5 = new Trainee(5, "Jas", "Arora", language, score5);

    private List<Trainee> listOfTrainee = Arrays.asList(trainee1, trainee2, trainee3, trainee4, trainee5);

    @Test
    public void checkAllEligibleTraineesTest(){
        PowerMockito.mockStatic(TraineeScoreCalculation.class);
        PowerMockito.when(TraineeScoreCalculation.checkIfEligible(trainee1)).thenReturn(true);
        PowerMockito.when(TraineeScoreCalculation.checkIfEligible(trainee2)).thenReturn(true);
        PowerMockito.when(TraineeScoreCalculation.checkIfEligible(trainee3)).thenReturn(true);
        PowerMockito.when(TraineeScoreCalculation.checkIfEligible(trainee4)).thenReturn(true);
        PowerMockito.when(TraineeScoreCalculation.checkIfEligible(trainee5)).thenReturn(true);
        String result = TraineeComparison.checkAllEligibleTrainees(listOfTrainee);
        assert (result == "Yipee!! All Trainees are eligible");

    }

    @Test
    public void checkAllEligibleTraineesForSomeMatchTest(){
        PowerMockito.mockStatic(TraineeScoreCalculation.class);
        PowerMockito.when(TraineeScoreCalculation.checkIfEligible(trainee1)).thenReturn(true);
        PowerMockito.when(TraineeScoreCalculation.checkIfEligible(trainee2)).thenReturn(true);
        PowerMockito.when(TraineeScoreCalculation.checkIfEligible(trainee3)).thenReturn(false);
        PowerMockito.when(TraineeScoreCalculation.checkIfEligible(trainee4)).thenReturn(false);
        PowerMockito.when(TraineeScoreCalculation.checkIfEligible(trainee5)).thenReturn(true);
        String result = TraineeComparison.checkAllEligibleTrainees(listOfTrainee);
        assert (result.equals("Some trainees are eligible"));

    }

    @Test
    public void checkAllEligibleTraineesNoneMatchTest(){
        PowerMockito.mockStatic(TraineeScoreCalculation.class);
        PowerMockito.when(TraineeScoreCalculation.checkIfEligible(trainee1)).thenReturn(false);
        PowerMockito.when(TraineeScoreCalculation.checkIfEligible(trainee2)).thenReturn(false);
        PowerMockito.when(TraineeScoreCalculation.checkIfEligible(trainee3)).thenReturn(false);
        PowerMockito.when(TraineeScoreCalculation.checkIfEligible(trainee4)).thenReturn(false);
        PowerMockito.when(TraineeScoreCalculation.checkIfEligible(trainee5)).thenReturn(false);
        String result = TraineeComparison.checkAllEligibleTrainees(listOfTrainee);
        assert (result == "Oops!! None of the trainee is eligible");

    }

    @Test
    public void getHighestScorerTest(){
        PowerMockito.mockStatic(TraineeScoreCalculation.class);
        PowerMockito.when(TraineeScoreCalculation.percentageCalculation(trainee1)).thenReturn(70.0);
        PowerMockito.when(TraineeScoreCalculation.percentageCalculation(trainee2)).thenReturn(46.0);
        PowerMockito.when(TraineeScoreCalculation.percentageCalculation(trainee3)).thenReturn(88.0);
        PowerMockito.when(TraineeScoreCalculation.percentageCalculation(trainee4)).thenReturn(60.0);
        PowerMockito.when(TraineeScoreCalculation.percentageCalculation(trainee5)).thenReturn(42.0);
        Trainee result = TraineeComparison.getHighestScorer(listOfTrainee);
        assert (result == trainee3);

    }

    @Test
    public void getLowestScorerTest(){
        PowerMockito.mockStatic(TraineeScoreCalculation.class);
        PowerMockito.when(TraineeScoreCalculation.percentageCalculation(trainee1)).thenReturn(70.0);
        PowerMockito.when(TraineeScoreCalculation.percentageCalculation(trainee2)).thenReturn(46.0);
        PowerMockito.when(TraineeScoreCalculation.percentageCalculation(trainee3)).thenReturn(88.0);
        PowerMockito.when(TraineeScoreCalculation.percentageCalculation(trainee4)).thenReturn(60.0);
        PowerMockito.when(TraineeScoreCalculation.percentageCalculation(trainee5)).thenReturn(42.0);
        Trainee result = TraineeComparison.getLowestScorer(listOfTrainee);
        assert (result == trainee5);

    }

    @Test
    public void countTraineeTest(){
        PowerMockito.mockStatic(TraineeScoreCalculation.class);
        Long result = TraineeComparison.countTrainee(listOfTrainee);
        assert (result == 5);

    }

    @Test
    public void sortByScoreTest(){
        PowerMockito.mockStatic(TraineeScoreCalculation.class);
        PowerMockito.when(TraineeScoreCalculation.percentageCalculation(trainee1)).thenReturn(70.0);
        PowerMockito.when(TraineeScoreCalculation.percentageCalculation(trainee2)).thenReturn(46.0);
        PowerMockito.when(TraineeScoreCalculation.percentageCalculation(trainee3)).thenReturn(88.0);
        PowerMockito.when(TraineeScoreCalculation.percentageCalculation(trainee4)).thenReturn(60.0);
        PowerMockito.when(TraineeScoreCalculation.percentageCalculation(trainee5)).thenReturn(42.0);
        List<String> result = TraineeComparison.sortByScore(listOfTrainee);
        System.out.println(result);
        List<String> expectedResult = Arrays.asList("Jas", "Simran", "Ram", "Jasmine", "Ruby");
        assert (result.equals(expectedResult));

    }

    @Test
    public void passTraineeTest(){
        PowerMockito.mockStatic(TraineeScoreCalculation.class);
        PowerMockito.when(TraineeScoreCalculation.percentageCalculation(trainee1)).thenReturn(70.0);
        PowerMockito.when(TraineeScoreCalculation.percentageCalculation(trainee2)).thenReturn(46.0);
        PowerMockito.when(TraineeScoreCalculation.percentageCalculation(trainee3)).thenReturn(88.0);
        PowerMockito.when(TraineeScoreCalculation.percentageCalculation(trainee4)).thenReturn(60.0);
        PowerMockito.when(TraineeScoreCalculation.percentageCalculation(trainee5)).thenReturn(42.0);
        Stream<Trainee> result = TraineeComparison.passTrainee(listOfTrainee);
        List<Trainee> expectedResultList = Arrays.asList(trainee1, trainee3);
        Stream<Trainee> expectedResult = expectedResultList.stream();
        assert (result.collect(Collectors.toList()).equals(expectedResultList));

    }

}