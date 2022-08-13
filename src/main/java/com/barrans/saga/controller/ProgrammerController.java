package com.barrans.saga.controller;

import com.barrans.saga.model.AverageKilled;
import com.barrans.saga.model.Person;
import com.barrans.saga.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/saga")
public class ProgrammerController {

    @Autowired
    private PersonService personService;

    @PostMapping("/programmer")
    public ResponseEntity<?> averageKilled(@RequestBody List<Person> persons) {
        if (!checkAge(persons)) {
            return ResponseEntity.ok(new AverageKilled(-1));
        }
        AverageKilled averagePeopleKilled = personService.averageNumberPeopleKilled(persons);
        return ResponseEntity.ok(averagePeopleKilled);
    }

    private boolean checkAge(List<Person> persons) {
        boolean status = true;
        for (Person person : persons) {
            if (person.getAgeOfDeath() < 0)
                status = false;
        }
        return status;
    }


}
