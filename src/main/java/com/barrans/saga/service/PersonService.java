package com.barrans.saga.service;

import com.barrans.saga.model.AverageKilled;
import com.barrans.saga.model.Person;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PersonService {

    AverageKilled averageNumberPeopleKilled(List<Person> persons);
}
