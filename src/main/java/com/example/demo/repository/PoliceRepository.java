package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Police;

@Repository
public interface PoliceRepository extends JpaRepository<Police, Integer> {

	public Police findByName(String name);

}
