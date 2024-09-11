package com.example.demo.service;

import com.example.demo.web.dto.ApiResponse;
import com.example.demo.web.dto.UserRegistrationDto;

public interface UserService {
//create a method for dto
	ApiResponse save(UserRegistrationDto userRegistrationDto);

	
}
