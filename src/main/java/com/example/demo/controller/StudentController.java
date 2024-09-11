package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.StudentModel;
import com.example.demo.service.StudentService;
import com.example.demo.studentDto.ApiResponseDto;
import com.example.demo.studentDto.LoginAuthenticationDto;
import com.example.demo.studentDto.ResetPasswordDto;

@RestController
@RequestMapping("/LoginPortal")
public class StudentController {

	@Autowired
	private StudentService studentService;

	@PostMapping("/register")
	public ApiResponseDto registerController(@RequestBody StudentModel studentModel) {
		return studentService.registerService(studentModel);
	}

	@PostMapping("/login")
	public ApiResponseDto loginController(@RequestBody LoginAuthenticationDto loginAuthenticationDto) {
		return studentService.loginService(loginAuthenticationDto);
	}

	@PostMapping("/resetPassword")
	public ApiResponseDto resetPasswordDtoCOntroller(@RequestBody ResetPasswordDto resetPasswordDto) {
		return studentService.resetPasswordService(resetPasswordDto);
	}
}
