package com.example.demo.reposiory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.CustomerUploadData;
@Repository
public interface CustomerRepository extends JpaRepository<CustomerUploadData, Integer> {

}
