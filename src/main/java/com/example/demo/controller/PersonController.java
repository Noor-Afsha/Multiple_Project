package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Doctor;
import com.example.demo.model.Student;
import com.example.demo.servce.PersonService;

@RestController
@RequestMapping("/crud")
public class PersonController {

	@Autowired
	private PersonService personService;

	@PostMapping("/save")
	public void saveController(@RequestBody Student student) {
		personService.saveService(student);
	}

	@PostMapping("/save1")
	public void saveController(@RequestBody Doctor doctor) {
		personService.saveService1(doctor);
	}

}
