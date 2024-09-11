package com.Wecoodee.cCustomerAppliaction.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.Wecoodee.cCustomerAppliaction.model.Student;
import com.Wecoodee.cCustomerAppliaction.repository.StudentRepository;

@Service
@Primary
public class StudentService1 {
	
	@Autowired
	private StudentRepository studentRepository;

	public Student createService(Student student) {
		return studentRepository.save(student);

	}

	public List<Student> getAll(List<Student> student) {
		return studentRepository.findAll();
	}

}
