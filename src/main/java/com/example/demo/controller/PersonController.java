package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Person;
import com.example.demo.service.PersonService;

@RestController
@RequestMapping("/One2One")
public class PersonController {

	@Autowired
	private PersonService personService;

	@PostMapping("/save")
	public void save(@RequestBody Person person) {
		personService.saveService(person);
	}

}
