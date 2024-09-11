package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.EmployeeModel;
import com.example.demo.service.EmployeeService;

@RestController
@RequestMapping("/list")
public class EmpController {


		@Autowired
		private EmployeeService employeeService;

		@PostMapping("/store")
		public EmployeeModel createController(@RequestBody EmployeeModel employee) {

			System.out.println("create controller is working");

		return	employeeService.createService(employee);

		}

	}


