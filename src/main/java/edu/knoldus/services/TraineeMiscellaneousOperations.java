package edu.knoldus.services;

import edu.knoldus.models.Trainee;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;


public interface TraineeMiscellaneousOperations {

    static Stream<Trainee> getSpecifiedTrainees(List<Trainee> listOfTrainee, int limit, int skip) {
        return listOfTrainee.stream().skip(skip).limit(limit);

    }

    static Stream<String> getDistinctLastName(List<Trainee> listOfTrainee){
        return listOfTrainee.stream().map(Trainee::getLastName).distinct();

    }

    static Stream<Trainee> createTraineeObjects(){
        IntStream intStream = IntStream.of(11,12,13);
        return intStream.mapToObj(Trainee::new);
    }

    static Integer findStartingId(List<Trainee> listOfTrainee){
        Optional<Trainee> trainee = listOfTrainee.stream().findFirst();
        if(trainee.isPresent()){
            return trainee.get().getId();
        }
        else {
            return -1;
        }

    }



}
