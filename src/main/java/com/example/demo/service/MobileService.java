package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Mobile;
import com.example.demo.repository.MobileRepository;

@Service
public class MobileService {

	@Autowired
	private MobileRepository mobileRepository;

	public void saveAllService(List<Mobile> mobile) {
		mobileRepository.saveAll(mobile);
	}
	
	public Optional<Mobile> findByIdService(int id) {
		return mobileRepository.findById(id);
	}
	
	public String deleteByIdService(int id) {
		 mobileRepository.deleteById(id);
		return "delete by id";
	}
 
	public String deleteAllService() {
		mobileRepository.deleteAll();
		return "Deleted successfully";
	}  
	
	public String updateService(int id) {
		mobileRepository.save(id);
		return "Updated Successfully";
	}
}
