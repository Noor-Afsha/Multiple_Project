package com.Wecoodee.CustomerAppliaction.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Wecoodee.CustomerAppliaction.model.Books;
import com.Wecoodee.CustomerAppliaction.model.Student;
import com.Wecoodee.CustomerAppliaction.repository.StudentReposiotory;

@Service
public class StudentBookService {

	@Autowired
	private StudentReposiotory studentReposiotory;

	public void saveService(Student student) {
		
		for(Books books:student.getBooks()) {
			books.setStudent(student);
		}
		student.setBooks(student.getBooks());
		
		studentReposiotory.save(student);
	}
	
	public void deleteService() {
		studentReposiotory.deleteAll();
	}
	
//	public void getAll() {
//		studentReposiotory.
//	}

}
