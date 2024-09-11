package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Employee;
import com.example.demo.repository.CarRepository;
import com.example.demo.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private CarRepository carRepository;

	public void SaveService(Employee employee) {
		employeeRepository.save(employee);
	}

	public List<Employee> saveAllService(List<Employee> employee) {
		return employeeRepository.saveAll(employee);
	}

	public List<Employee> findByEmployeeIdService(String name) {
		return employeeRepository.findByName(name);
	}

	public List<Employee> findByCollegeService(String college) {
		return employeeRepository.findByCollege(college);
	}

	public List<Employee> getByNameService(String name) {
		return employeeRepository.getByName(name);
	}

	public List<Employee> queryByNameService(String n) {
		return employeeRepository.queryByName(n);
	}

	public List<Employee> findByNameAndCollegeService(String name1, String college1) {
		return employeeRepository.findByNameAndCollege(name1, college1);
	}

	public List<Employee> countByNameService(String name2) {
		return employeeRepository.countByName(name2);
	}

	public List<String> getAllNameService(String name) {
		List<String> nameList = employeeRepository.getAllName(name);
		if (nameList != null) {
			return nameList;
		} else {
			return null;
		}
		
		}
	public void deleteService(int id) {
	 employeeRepository.deleteById(id);	
	}
}