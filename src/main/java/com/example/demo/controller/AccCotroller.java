package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.AccModel;
import com.example.demo.service.AccService;

@RestController
@RequestMapping("/acc")
public class AccCotroller {

	@Autowired
	private AccService accService;

	@PostMapping("/create")
	public AccModel create(@RequestBody AccModel accModel) {
		return accService.createService(accModel);
	}

}
