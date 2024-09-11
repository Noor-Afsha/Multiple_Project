package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Chocolate;

public interface ChocolateRepositor extends JpaRepository<Chocolate, Integer> {

}
