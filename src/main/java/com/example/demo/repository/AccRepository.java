package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.AccModel;

@Repository
public interface AccRepository extends JpaRepository<AccModel, Integer> {

	public AccModel getByAccountNumber(String accountNumber);

}
