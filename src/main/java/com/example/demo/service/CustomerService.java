package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.ApiResponse;
import com.example.demo.model.CustomerUploadData;
import com.example.demo.reposiory.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	public ApiResponse createService(CustomerUploadData customerUploadData) {
		System.out.println("inside the create service method is executed");
		CustomerUploadData customerUploadData2 = customerRepository.save(customerUploadData);

		if (customerUploadData2 != null) {
			return ApiResponse.success("Success");
		} else {
			return ApiResponse.failed("operationed failed");
		}
	}

}
