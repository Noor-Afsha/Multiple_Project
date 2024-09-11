package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.model.Address;
import com.example.demo.repositories.ValidRepository;

@Service
public class ValidService {

	@Autowired
	private ValidRepository validRepository;

	public Address test(@RequestBody Address address) {

		return validRepository.save(address);
	}

}
