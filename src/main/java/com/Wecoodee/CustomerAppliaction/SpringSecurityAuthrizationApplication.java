package com.Wecoodee.CustomerAppliaction;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.Wecoodee.CustomerAppliaction.model.User;
import com.Wecoodee.CustomerAppliaction.repository.UserRepository;

import jakarta.annotation.PostConstruct;

@SpringBootApplication
public class SpringSecurityAuthrizationApplication {

	@Autowired
	private UserRepository userRepository;

	@PostConstruct
	public void initUsers() {
		List<User> users= Stream.of(
				new User(id:101, userName:"Noor", password:"Noor@123", emailId:"noor@123")

				).Collect(Collectors.toList());
	userRepository.saveAll(users);
		}
	
	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityAuthrizationApplication.class, args);
	}

}
