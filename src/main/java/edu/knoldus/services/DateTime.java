package edu.knoldus.services;

import java.time.LocalDate;
import java.time.Period;
import java.util.stream.Stream;

public class DateTime {

    String ageOfPerson() {

        LocalDate currentDate = LocalDate.now();
        LocalDate birthDate = LocalDate.of(1995, 1, 3);

        Period period = Period.between(birthDate, currentDate);
        int years = period.getYears();
        int months = period.getMonths();
        int days = period.getDays();
        return "Your current age is " + years + " years " + months + " months " + days + " days.";
    }
}
