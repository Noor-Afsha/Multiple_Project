package com.Wecoodee.CustomerAppliaction.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Wecoodee.CustomerAppliaction.model.Student;
import com.Wecoodee.CustomerAppliaction.service.StudentBookService;

@RestController
@RequestMapping("/test")
public class StudentBookController {

	@Autowired
	private StudentBookService studentBookService;

	@PostMapping("/save")
	public void savecontroller(@RequestBody Student student) {
		studentBookService.saveService(student);
	}

	@DeleteMapping("/delete")
	public void deleteController() {
		studentBookService.deleteService();
	}

}
