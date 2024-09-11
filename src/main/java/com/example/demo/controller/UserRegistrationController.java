package com.example.demo.controller;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.UserService;
import com.example.demo.web.dto.ApiResponse;
import com.example.demo.web.dto.UserRegistrationDto;

@RestController
@RequestMapping("/demo")
public class UserRegistrationController {

	private UserService userService;

	public ApiResponse registerUserAccount(@ModelAttribute("user") UserRegistrationDto userRegistrationDto) {
		return userService.save(userRegistrationDto);
//		return "redirect:/registration?success";

	}

}
