//package com.Wecoodee.CustomerAppliaction.controller;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.access.prepost.PostAuthorize;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.Wecoodee.CustomerAppliaction.model.User;
//import com.Wecoodee.CustomerAppliaction.service.CustomUserDetailsService;
//
//@RestController
//@RequestMapping("/mapping")
//public class WelcomeController {
//
//	@Autowired
//	private CustomUserDetailsService customUserDetailsService;
//
//	@GetMapping("/")
//	public String welcomeController() {
//		return "welcome to our login auhentication page";
//	}
//
//	@PostMapping("/saveAll")
//	public List<User> saveAllController(@RequestBody List<User> user) {
//		return customUserDetailsService.saveAllService(user);
//
//	}
//
//}
