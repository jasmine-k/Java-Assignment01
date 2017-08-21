package edu.knoldus.services;

import static org.junit.Assert.*;

import edu.knoldus.models.Trainee;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TraineeMiscellaneousOperationsTest implements TraineeMiscellaneousOperations{

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
    public void getSpecifiedTraineesTest(){
        Stream<Trainee> result = TraineeMiscellaneousOperations.getSpecifiedTrainees(listOfTrainee, 2,1);
        List<Trainee> expectedResultList = Arrays.asList(trainee2, trainee3);
        assert (result.collect(Collectors.toList()).equals(expectedResultList));

    }

    @Test
    public void getDistinctLastNameTest(){
        Stream<String> result = TraineeMiscellaneousOperations.getDistinctLastName(listOfTrainee);
        List<String> expectedResultList = Arrays.asList("Kaur", "Sharma","Singh","Arora");
        Stream<String> expectedResult = expectedResultList.stream();
        assert (result.collect(Collectors.toList()).equals(expectedResult.collect(Collectors.toList())));

    }


    @Test
    public void createTraineeObjectsTest(){

        Trainee tempTrainee1 = new Trainee(11);
        Trainee tempTrainee2 = new Trainee(12);
        Trainee tempTrainee3 = new Trainee(13);
        Stream<Trainee> result = TraineeMiscellaneousOperations.createTraineeObjects();
        List<Trainee> expectedResultList = Arrays.asList(tempTrainee1,tempTrainee2,tempTrainee3);
        assert (result.collect(Collectors.toList()).get(0).getId() == (expectedResultList.get(0).getId()));

    }

    @Test
    public void findStartingIdTest(){
        Integer id = TraineeMiscellaneousOperations.findStartingId(listOfTrainee);
        assert (id == 1);
    }

    @Test
    public void findStartingIdNoneMatchTest(){
        Integer id = TraineeMiscellaneousOperations.findStartingId(new ArrayList<Trainee>());
        assert (id == -1) ;
    }

}