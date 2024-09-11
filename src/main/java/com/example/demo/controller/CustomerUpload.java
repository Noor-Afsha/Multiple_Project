package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.ApiResponse;
import com.example.demo.model.CustomerUploadData;
import com.example.demo.service.CustomerService;

@RestController
@RequestMapping("/cust")
public class CustomerUpload {

	@Autowired
	private CustomerService customerService;

	@PostMapping("/create")
	public ApiResponse create(@RequestBody CustomerUploadData customerUploadData) {
		System.out.println("inside the create controller api is working");
		return customerService.createService(customerUploadData);
	}
}
