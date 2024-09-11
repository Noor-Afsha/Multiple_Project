package com.Wecoodee.CustomerAppliaction.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Wecoodee.CustomerAppliaction.model.Student;

@Repository
public interface StudentReposiotory extends JpaRepository<Student, Integer>{

}
