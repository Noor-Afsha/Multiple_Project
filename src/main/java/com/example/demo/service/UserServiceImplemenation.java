package com.example.demo.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Role;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.web.dto.ApiResponse;
import com.example.demo.web.dto.UserRegistrationDto;

@Service
public class UserServiceImplemenation implements UserService {
	@Autowired
	private UserRepository userRepository;
	
	public UserServiceImplemenation(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	@Override
	public ApiResponse save(UserRegistrationDto userRegistrationDto) {
		ApiResponse apiResponse=new ApiResponse();
		User user=new User(userRegistrationDto.getFirstName(), userRegistrationDto.getLastName(),
				userRegistrationDto.getEmail(), userRegistrationDto.getPassword(),Arrays.asList(new Role("Role_user")));
		User m1=userRepository.save(user);
	
		return apiResponse;
		
	}
}