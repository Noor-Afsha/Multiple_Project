package com.Wecoodee.cCustomerAppliaction.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Wecoodee.cCustomerAppliaction.Model.StudentModel;
import com.Wecoodee.cCustomerAppliaction.repository.StudentRepository;

@RestController
@RequestMapping("/Application")
public class StudentController {

	@Autowired
	private StudentRepository studentRepository;
	@PostMapping("/create")
	public StudentModel createController(@RequestBody StudentModel studentModel) {
		return studentRepository.save(studentModel);
	}

	@PostMapping("/update")
	public StudentModel updateController(@RequestBody StudentModel studentModel) {
		try {
			StudentModel sm = studentRepository.findByName(studentModel.getName());
			if (sm != null) {
				studentModel.setRollNumber(sm.getRollNumber());
				StudentModel smm = studentRepository.save(studentModel);
				return smm;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
