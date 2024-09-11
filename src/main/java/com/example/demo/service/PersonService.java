package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Person;
import com.example.demo.model.PersonDetails;
import com.example.demo.repository.PersonDeailsRepository;
import com.example.demo.repository.PersonRepository;

@Service
public class PersonService {
	@Autowired
	private PersonRepository personRepository;

	@Autowired
	private PersonDeailsRepository personDeailsRepository;

	public void saveService(Person person) {
		System.out.println("Inside saveService method");
		PersonDetails personDetails = person.getPersonDetails();
		PersonDetails personDetailsFrmDb = personDeailsRepository.save(personDetails);
		int id = personDetailsFrmDb.getPerid();
		person.setId(id);
		personRepository.save(person);
	}

}
