package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Emp;
import com.example.demo.services.Many2OneService;

@RestController
@RequestMapping(name = "MANYTOONE")

public class Many2OneController {

	@Autowired
	private Many2OneService many2OneService;

	@PostMapping("/save")
	public List<Emp> saveRecord(@RequestBody List<Emp> emp) {
		return many2OneService.saveRecordService(emp);

	}
}
