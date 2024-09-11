package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.TableB;

@Repository
public interface TableBRepository extends JpaRepository<TableB, String>{

}
