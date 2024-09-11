package com.Wecoodee.CustomerAppliaction.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/security")
public class SecurityController {

	@GetMapping("/auth")
	public String controller() {

		return "security parameters is working";
	}
}
//	@GetMapping("/service")
//	public String Service() {
//		return "Students id are enrolled in the collges";
//	}
//	
//	@GetMapping("/login")
//	public Object login() {
//		
//		String username = "Noor";
//		
//		String passord= "Noor@123";
//		
//		return "login is executed";
//return "login";
//	}
//}
