package edu.knoldus.services;

import edu.knoldus.models.Trainee;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TraineeMain extends DateTime{

    public static void main(String...args){

        String[] language = {"Scala","Akka","Play","Java", "C++"};
        double[] score1 = {60,80,90,100,20};
        double[] score2 = {20,100,60,10,40};
        double[] score3 = {70,100,70,100,100};
        double[] score4 = {90,90,20,50,50};
        double[] score5 = {40,10,30,60,70};

        Trainee trainee1 = new Trainee(1,"Jasmine","Kaur",language, score1);
        Trainee trainee2 = new Trainee(2,"Simran","Kaur",language, score2);
        Trainee trainee3 = new Trainee(3,"Ruby","Sharma",language, score3);
        Trainee trainee4 = new Trainee(4,"Ram","Singh",language, score4);
        Trainee trainee5 = new Trainee(5,"Jas","Arora",language, score5);

        List<Trainee> listOfTrainee = Arrays.asList(trainee1,trainee2,trainee3,trainee4,trainee5);
    //    List<String> expectedResult = Arrays.asList("Jas", "Simran", "Ram", "Jasmine", "Ruby");

        System.out.println(TraineeComparison.checkAllEligibleTrainees(listOfTrainee));
        System.out.println();
        System.out.println(TraineeComparison.countTrainee(listOfTrainee));
        System.out.println();
        TraineeComparison.getHighestScorer(listOfTrainee).displayName();
        System.out.println();
        TraineeComparison.getLowestScorer(listOfTrainee).displayName();
        System.out.println();
        System.out.println(TraineeComparison.sortByScore(listOfTrainee));
     //   System.out.println(expectedResult);
        System.out.println();
        TraineeComparison.passTrainee(listOfTrainee).forEach(Trainee::displayName);
        System.out.println();
        TraineeMiscellaneousOperations.getSpecifiedTrainees(listOfTrainee,1,1).forEach(Trainee::displayName);
        System.out.println();
        TraineeMiscellaneousOperations.getDistinctLastName(listOfTrainee).forEach(System.out::println);
        System.out.println();
        TraineeMiscellaneousOperations.createTraineeObjects().forEach(trainee -> System.out.println(trainee.getId()));
        System.out.println();
        System.out.println(TraineeMiscellaneousOperations.findStartingId(listOfTrainee));
        DateTime dateTime = new DateTime();
        System.out.println(dateTime.ageOfPerson());
        System.out.println();
      //  System.out.println(TraineeComparison.sortByScore(listOfTrainee) == expectedResult);


    }
}
