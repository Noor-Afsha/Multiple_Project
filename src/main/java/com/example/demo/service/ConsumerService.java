package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Customer;
import com.example.demo.repository.ConsumerRepositry;

@Service
public class ConsumerService {

	@Autowired
	private ConsumerRepositry consumerRepositry;

	public Customer submitService(Customer customer) {
		System.out.println("inside the submit service method method is excuted");
		return consumerRepositry.save(customer);
	}

}
