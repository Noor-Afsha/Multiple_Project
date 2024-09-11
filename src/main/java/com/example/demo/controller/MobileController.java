package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Mobile;
import com.example.demo.service.MobileService;

@RestController

@RequestMapping("crud")

public class MobileController {

	@Autowired
	private MobileService mobileService;

	@PostMapping("saveAll")
	public void saveAllController(@RequestBody List<Mobile> mobile) {
		mobileService.saveAllService(mobile);
	}

	@GetMapping("findById/{id}")
	public Optional<Mobile> findByIdConroller(@PathVariable int id) {
		return mobileService.findByIdService(id);
	}
	
	@GetMapping("deleteById/{id}")
	public String deleteByIdController(@PathVariable int id) {
		return mobileService.deleteByIdService(id);
	}
	
	@GetMapping("deleteAll")
	public String deleteALlController() {
		return  mobileService.deleteAllService();
	}
  
	@PostMapping("update/{id}")
	public String updateService(@RequestBody int id) {
		return mobileService.updateService(id);
		
	}
}
