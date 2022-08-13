package com.barrans.saga;

import com.barrans.saga.model.AverageKilled;
import com.barrans.saga.model.Person;
import com.barrans.saga.service.PersonService;
import com.barrans.saga.service.PersonServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class ProgrammerTests {

	@Autowired
	PersonService personService;

	@Autowired
	PersonServiceImpl personServiceImpl;

	List<Person> persons = new ArrayList<>();

	@BeforeEach
	public void setup() {
		Person person1 = new Person(10, 12);
		Person person2 = new Person(13, 17);
		persons.add(person1);
		persons.add(person2);
	}

	@Test
	@DisplayName("Number of People Killed in Year")
	void numberOfKillInYearTest() {
		// Tahun ke-4 ada 7 orang yang terbunuh
		int killedPeopleInYear = personServiceImpl.numberOfKillYear(4);
		assertEquals(7, killedPeopleInYear);
	}

	@Test
	@DisplayName("Average People Killed")
	void averageNumberPeopleKilledTest() {
		AverageKilled averageKilled = personService.averageNumberPeopleKilled(persons);
		assertEquals(4.5, averageKilled.getAverageKilled());
	}
}
