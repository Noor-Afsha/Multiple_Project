package com.Wecoodee.cCustomerAppliaction.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Wecoodee.cCustomerAppliaction.bean.TestBean;
import com.Wecoodee.cCustomerAppliaction.lazy.LazyLoading;
import com.Wecoodee.cCustomerAppliaction.model.Student;
import com.Wecoodee.cCustomerAppliaction.repository.StudentServiceInterface;
import com.Wecoodee.cCustomerAppliaction.service.StudentService;
import com.Wecoodee.cCustomerAppliaction.service.StudentService1;

@RestController
@RequestMapping("/annotations")
public class StudentConroller {

	@Autowired
//	@Qualifier("StudentService")
	private StudentService1 studentService1;

	@Autowired
	private TestBean testBean;

	@Autowired
	private LazyLoading lazyLoading;

	@PostMapping("/create")
	public Student createController(@RequestBody Student student) {
		return studentService1.createService(student);
	}

	@GetMapping("/get")
	public List<Student> getAll(List<Student> student) {
		testBean.method();
		return studentService1.getAll(student);
	}

}
