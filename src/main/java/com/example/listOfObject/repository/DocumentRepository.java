package com.example.listOfObject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.listOfObject.model.Document;
@Repository
public interface DocumentRepository extends JpaRepository<Document,Integer>{

}
