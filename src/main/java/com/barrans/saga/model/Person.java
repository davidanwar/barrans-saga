package com.barrans.saga.model;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Person {

    private Integer ageOfDeath;
    private Integer yearOfDeath;
}
