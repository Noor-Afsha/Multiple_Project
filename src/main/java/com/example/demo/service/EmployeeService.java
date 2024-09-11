package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.EmployeeModel;
import com.example.demo.repository.EmployeeRepsitory;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepsitory employeeRepsitory;

	public EmployeeModel createService(EmployeeModel employee) {
		System.out.println("inside the create service method is executed");
		return employeeRepsitory.save(employee);
	}

}
