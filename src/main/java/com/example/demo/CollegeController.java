package com.example.demo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/college")
public class CollegeController {

	@GetMapping("/{id}")
	public ResponseEntity<College> getCollegeDetails(@PathVariable Long id) {

		College c1 = new College();

		c1.setId(1);
		c1.setCollegeName("RRIMT");
		c1.setAddress("Lucknow");

		return new ResponseEntity<College>(c1, HttpStatus.OK);
	}
}
