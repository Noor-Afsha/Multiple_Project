package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.AccModel;
import com.example.demo.repository.AccRepository;

@Service
public class AccService {

	@Autowired
	private AccRepository accRepository;

	public AccModel createService(AccModel accModel) {

		if (accModel.getAccountNumber().length() != 20) {

			throw new IllegalArgumentException("Account number should be exactly 20 characters");
		}

		AccModel accModel2 = accRepository.getByAccountNumber(accModel.getAccountNumber());

		if (accModel2 != null) {
			throw new IllegalArgumentException("duplicate account number");
		} else {
			return accRepository.save(accModel);

		}
	}

}
