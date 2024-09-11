package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.Student;

@RestController
@RequestMapping("/adapter")
public class AdapterController {

	@GetMapping("/api1")
	public void callProject() {
		System.out.println("hi printing the project b");
	}

	@GetMapping("/api2/{name}")
	public void secondMethod(@PathVariable String name) {
		try {
			System.out.println("inside the try and catch block");

			System.out.println("posting name:  "+ name );
		} catch (Exception e) {

			System.out.println("exception" + e);
		}
	}

	@GetMapping("/api3")
	public String response() {
		try {

			System.out.println("giving response from adapter");
		} catch (Exception e) {
			System.out.println("exception" + e);
		}
		return "getting response from adapter";
	}

	@PostMapping("/api4")
	public Object printObject(@RequestBody Student student) {
		return student;
	

			
	}
}
