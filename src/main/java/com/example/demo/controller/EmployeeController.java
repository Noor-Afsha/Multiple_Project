package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;

@RestController

@RequestMapping("crud")

public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@PostMapping("save")
	public void saveController(@RequestBody Employee employee) {
		employeeService.SaveService(employee);
	}

	@PostMapping("/saveAll")
	public List<Employee> saveAllController(@RequestBody List<Employee> employee) {
		return employeeService.saveAllService(employee);
	}

	@GetMapping("/employee/{name}")
	public List<Employee> findByEmployeeIdController(@PathVariable String name) {
		return employeeService.findByEmployeeIdService(name);
	}

	@GetMapping("/employee1/{collge}")
	public List<Employee> findByCollegeController(@PathVariable String collge) {
		return employeeService.findByCollegeService(collge);
	}

	@GetMapping("/emp/{names}")
	public List<Employee> getByNameController(@PathVariable String names) {
		return employeeService.getByNameService(names);
	}

	@GetMapping("/query/{n}")
	public List<Employee> queryByNameController(@PathVariable String n) {
		return employeeService.getByNameService(n);
	}

	@GetMapping("/find/{name1}/{college1}")
	public List<Employee> findByNameandCollegeController(@PathVariable String name1, @PathVariable String college1) {
		return employeeService.findByNameAndCollegeService(name1, college1);
	}

	// only display string
	@GetMapping("/get/{allNameList}")
	public List<String> getAllNameController(@PathVariable String allNameList) {
		return employeeService.getAllNameService(allNameList);
	}
	@DeleteMapping("/delete/{id}")
	public void deleteByIdController(@PathVariable int id) {
		employeeService.deleteService(id);
	}
}
