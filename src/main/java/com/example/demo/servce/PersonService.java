package com.example.demo.servce;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Doctor;
import com.example.demo.model.Student;
import com.example.demo.repository.DoctorRepository;
import com.example.demo.repository.StudentRepository;

@Service
public class PersonService {

	@Autowired
	private StudentRepository studentRepository;

	@Autowired
	private DoctorRepository doctorRepository;

	public void saveService(Student student) {
		studentRepository.save(student);
	}

	public void saveService1(Doctor doctor) {
		doctorRepository.save(doctor);

	}
}
