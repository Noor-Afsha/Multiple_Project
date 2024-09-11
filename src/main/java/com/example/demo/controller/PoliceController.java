package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Police;
import com.example.demo.service.PoliceService;

@RestController
@RequestMapping("/test")
public class PoliceController {

	@Autowired
	private PoliceService policeService;

	@PostMapping("/submit")
	public Police saveController(@RequestBody Police police) {
		return policeService.saveService(police);
	}

	@PostMapping("/saveAll")
	public List<Police> saveAll(@RequestBody List<Police> police) {
		return policeService.saveAllService(police);

	}

	@GetMapping("/find/{name}")
	public Police findByNameController(@PathVariable String name) {
		return policeService.getByNameService(name);
	}
}
