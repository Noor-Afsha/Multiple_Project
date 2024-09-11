package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
	private StudentRepository studentRepository;
//
//	@Autowired
//	private ChocolateRepositor chocolateRepositor;

	public Student saveService(Student student) {
		return studentRepository.save(student);

	}

	public List<Student> saveAll(List<Student> student) {

		return studentRepository.saveAll(student);
	}

	public String deleteByIdService(int id) {
		studentRepository.deleteById(id);
		return "records deleted by id successfully";
	}

	public List<Student> getAllService() {
		return studentRepository.findAll();
	}

	public void updateService(Student student) {
     
		studentRepository.save(student);
	}
}
