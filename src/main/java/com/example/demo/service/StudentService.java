package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.StudentModel;
import com.example.demo.studentDto.ApiResponseDto;
import com.example.demo.studentDto.LoginAuthenticationDto;
import com.example.demo.studentDto.ResetPasswordDto;
import com.example.demo.studentRepository.StudentRepository;

@Service
public class StudentService {
	@Autowired
	private StudentRepository studentRepository;

	// method for only register student
	public ApiResponseDto registerService(StudentModel studentModel) {
		System.out.println("Register method executed");// check weather method is executed or no
		ApiResponseDto registerApiResponseDto = new ApiResponseDto();// creating object for api response
		try {
			StudentModel sm = studentRepository.save(studentModel);
			if (sm != null) {
				registerApiResponseDto.setStatusCode(1);
				registerApiResponseDto.setStatus("OPERATION SUCCESS");
				registerApiResponseDto.setMessage("Student Registered Successfully");
				return registerApiResponseDto;

			}
		} catch (Exception e) {
			e.printStackTrace();
			registerApiResponseDto.setStatusCode(0);
			registerApiResponseDto.setStatus("OPERATION FAILED");
			registerApiResponseDto.setMessage(null);
			return registerApiResponseDto;
		}
		return null;
	}

	public ApiResponseDto loginService(LoginAuthenticationDto loginAuthenticationDto) {
		System.out.println("student login authentication dto is executed");
		ApiResponseDto loginApiResponseDto = new ApiResponseDto();
		try {
			StudentModel smm = studentRepository.findByEmailId(loginAuthenticationDto.getEmailAddress());

			if (smm != null) {
				if (smm.getPassword().equals(loginAuthenticationDto.getPassword())) {

					loginApiResponseDto.setStatusCode(1);
					loginApiResponseDto.setStatus("OPERATION SUCCESS");
					loginApiResponseDto.setMessage("Student login Successfully");
					return loginApiResponseDto;
				}
				loginApiResponseDto.setStatusCode(0);
				loginApiResponseDto.setStatus("OPERATION FAIED");
				loginApiResponseDto.setMessage("Invalid password");
				return loginApiResponseDto;
			}
			loginApiResponseDto.setStatusCode(0);
			loginApiResponseDto.setStatus("OPERATION FAILED");
			loginApiResponseDto.setMessage("Invalid user");
			return loginApiResponseDto;
		} catch (Exception e) {
			e.printStackTrace();
			loginApiResponseDto.setStatusCode(0);
			loginApiResponseDto.setStatus("OPERATION FAILED");
			loginApiResponseDto.setMessage(null);
		}
		return null;
	}

	public ApiResponseDto resetPasswordService(ResetPasswordDto resetPasswordDto) {
		System.out.println("reset password method is executed");
		ApiResponseDto resetPasswordDtoApiResponseDto = new ApiResponseDto();
		try {
			StudentModel smmm = studentRepository.findByEmailId(resetPasswordDto.getEmailId());
			if (smmm != null) {
				if (smmm.getPassword().equals(resetPasswordDto.getOldPassword())) {
					if (resetPasswordDto.getNewPassword() != null) {
						smmm.setPassword(resetPasswordDto.getNewPassword());
						studentRepository.save(smmm);

						resetPasswordDtoApiResponseDto.setStatusCode(0);
						resetPasswordDtoApiResponseDto.setStatus("OPERATION SUCCESS");
						resetPasswordDtoApiResponseDto.setMessage("password changed uccessfully");
						return resetPasswordDtoApiResponseDto;

					}
				}
				resetPasswordDtoApiResponseDto.setStatusCode(0);
				resetPasswordDtoApiResponseDto.setStatus("OPERATION FAILED");
				resetPasswordDtoApiResponseDto.setMessage("Old password is wrong");
				return resetPasswordDtoApiResponseDto;
			}
			resetPasswordDtoApiResponseDto.setStatusCode(0);
			resetPasswordDtoApiResponseDto.setStatus("OPERATION FAILED");
			resetPasswordDtoApiResponseDto.setMessage("User not found");
			return resetPasswordDtoApiResponseDto;

		} catch (Exception e) {
			resetPasswordDtoApiResponseDto.setStatusCode(0);
			resetPasswordDtoApiResponseDto.setStatus("OPERATION FAILED");
			resetPasswordDtoApiResponseDto.setMessage("Internal Error");
			return resetPasswordDtoApiResponseDto;

		}
	}
}
