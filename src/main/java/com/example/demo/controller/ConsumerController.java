package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Customer;
import com.example.demo.service.ConsumerService;

@RestController
@RequestMapping("/consume")
public class ConsumerController {

	@Autowired
	private ConsumerService consumerService;

	@PostMapping("/submit")
	public Customer submitController(@RequestBody Customer customer) {
		System.out.println("inside the submit cntroller");
		return consumerService.submitService(customer);
	}
}
