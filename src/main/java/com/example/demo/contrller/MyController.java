package com.example.demo.contrller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.ResturantModel;
import com.example.demo.service.MyService;

@RestController
@RequestMapping("/crud")
public class MyController {
@Autowired
private MyService myService;
@PostMapping("/save")
public ResturantModel saveContrller(@RequestBody ResturantModel rm) {
	return myService.saveService(rm);
	
}
}
