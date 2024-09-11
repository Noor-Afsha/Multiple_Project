package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Police;
import com.example.demo.repository.PoliceRepository;

@Service
public class PoliceService {

	@Autowired
	private PoliceRepository policeRepository;

	public Police saveService(Police police) {
		return policeRepository.save(police);

	}

	public List<Police> saveAllService(List<Police> police) {
		return policeRepository.saveAll(police);
	}

	public Police getByNameService(String name) {
		Police p= policeRepository.findByName(name);
		if(p!=null) {
			return p;
		}
		return p;
		
	}

}
