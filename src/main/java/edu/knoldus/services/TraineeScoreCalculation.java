package edu.knoldus.services;

import edu.knoldus.models.Trainee;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Stream;

public interface TraineeScoreCalculation {

    static boolean checkIfEligible(Trainee trainee) {
        double[] scores = trainee.getScore();
        return Arrays.stream(scores).allMatch(value -> value > 60.0);
    }

    static double percentageCalculation(Trainee trainee){
        double[] scores = trainee.getScore();
        OptionalDouble sum = Arrays.stream(scores).reduce((score1,score2)-> score1+score2);
        if(sum.isPresent()){
            return sum.getAsDouble()/countLanguages(trainee);
        }
        else{
            return 0.0;
        }
    }

    static long countLanguages(Trainee trainee){
        String[] listOfLanguages = trainee.getLanguage();
        return Arrays.stream(listOfLanguages).count();
    }
}
