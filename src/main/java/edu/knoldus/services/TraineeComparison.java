package edu.knoldus.services;

import edu.knoldus.models.Trainee;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public interface TraineeComparison extends TraineeScoreCalculation {

    /*
    * Terminal Operations
    * */

    static String checkAllEligibleTrainees(List<Trainee> listOfTrainee) {
        if (listOfTrainee.stream().allMatch(trainee -> TraineeScoreCalculation.checkIfEligible(trainee))) {
            return "Yipee!! All Trainees are eligible";
        } else if (listOfTrainee.stream().anyMatch(trainee -> TraineeScoreCalculation.checkIfEligible(trainee))) {
            return "Some trainees are eligible";
        } else {
            return "Oops!! None of the trainee is eligible";
        }

    }

    static Trainee getHighestScorer(List<Trainee> listOfTrainee) {
        return listOfTrainee.stream().max(Comparator.comparing(TraineeScoreCalculation::percentageCalculation)).get();

    }

    static Trainee getLowestScorer(List<Trainee> listOfTrainee) {
        return listOfTrainee.stream().min(Comparator.comparing(TraineeScoreCalculation::percentageCalculation)).get();

    }

    static long countTrainee(List<Trainee> listOfTrainee) {
        return listOfTrainee.stream().count();

    }

    /*
    * Intermediate Operations
    */

    static List<String> sortByScore(List<Trainee> listOfTrainee) {
        return listOfTrainee.stream().sorted(Comparator.comparing(TraineeScoreCalculation::percentageCalculation))
                .map(Trainee::getFirstName)
                .collect(Collectors.toList());

    }

    static Stream<Trainee> passTrainee(List<Trainee> listOfTrainee) {
        return listOfTrainee.stream().filter(trainee -> TraineeScoreCalculation.percentageCalculation(trainee) > 60);

    }


    static double averageScore(Trainee trainee) {
        return Arrays.stream(trainee.getScore().stream()).collect(Collectors.averagingDouble(trainee.getScore()));

    }

/*
    static Stream<Trainee> getTrainee(List<Trainee> listOfTrainee, int limit, int skip) {
        return listOfTrainee.stream().limit(limit).skip(skip);

    }

    static Stream<String> getDistinctLastName(List<Trainee> listOfTrainee){
        return listOfTrainee.stream().map(Trainee::getLastName).distinct();
        //return listOfTrainee.get.distinct();
    }
*/

/*
    static void debugName(List<Trainee> listOfTrainee){
        listOfTrainee.stream().peek(value-> System.out.println(value)).forEach(System.out::println);
    }*/

}
