package com.barrans.saga.service;

import com.barrans.saga.model.AverageKilled;
import com.barrans.saga.model.Person;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {

    @Override
    public AverageKilled averageNumberPeopleKilled(List<Person> persons) {

        List<Integer> numberOfKilled = new ArrayList<>();
        persons.forEach(person -> {
            int killed = person.getYearOfDeath() - person.getAgeOfDeath();
            numberOfKilled.add(numberOfKillYear(killed));
        });

        double averagePeopleKilled = numberOfKilled
                .stream().mapToDouble(value -> value)
                .average()
                .orElse(0.0);
        return new AverageKilled(averagePeopleKilled);
    }

    public int numberOfKillYear(int numberOfYear) {
        int peopleDeath = 1;
        for (int i = 1; i < numberOfYear; i++ ) {
            peopleDeath = peopleDeath + i;
        }
        return peopleDeath;
    }
}
