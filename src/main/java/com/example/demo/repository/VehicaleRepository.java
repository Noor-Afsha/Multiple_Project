package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Vehicale;

@Repository
public interface VehicaleRepository extends JpaRepository<Vehicale, Integer>{

}
