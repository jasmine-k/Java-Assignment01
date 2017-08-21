package edu.knoldus.services;

import org.junit.Test;

import static org.junit.Assert.*;

public class DateTimeTest {
    @Test
    public void ageOfPersonTest() {
        DateTime dateAndTimeExample = new DateTime();
        String result = dateAndTimeExample.ageOfPerson();

        assertEquals(result, "Your current age is 22 years 7 months 18 days.");

    }
}
