package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Emp;
import com.example.demo.repository.ManyToOneRepo;

@Service
public class Many2OneService {

	@Autowired
	private ManyToOneRepo manyToOneRepo;

	public List<Emp> saveRecordService(List<Emp> emp) {
		return manyToOneRepo.saveAll(emp);
	}

}
