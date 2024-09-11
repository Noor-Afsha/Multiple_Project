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

import com.example.demo.model.Student;
import com.example.demo.service.StudentService;

@RestController
@RequestMapping("/crud")
public class SrudentController {

	@Autowired
	private StudentService studentService;

	@PostMapping("save")
	public Student saveConroller(@RequestBody Student student) {
		return studentService.saveService(student);
	}

	@PostMapping("/saveAll")
	public List<Student> saveAll(@RequestBody List<Student> student) {
		return studentService.saveAll(student);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteByIdController(@PathVariable int id) {
		return studentService.deleteByIdService(id);

	}

	@GetMapping("/getAll")
	public List<Student> getAllController() {
		return studentService.getAllService();
	}

	@PostMapping("/update")
	public void updateService(@RequestBody Student student) {
		studentService.updateService(student);
	}
}