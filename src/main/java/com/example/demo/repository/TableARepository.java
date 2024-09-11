package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.TableA;

@Repository
public interface TableARepository extends JpaRepository<TableA, String>{

}
