package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.ResturantModel;
import com.example.demo.repository.MyRepository;

@Service
public class MyService {
@Autowired
private MyRepository myRepository;

public ResturantModel saveService(ResturantModel  rm) {
	return myRepository.save(rm);	
}


}
