package com.example.demo.studentRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.StudentModel;
import com.example.demo.studentDto.LoginAuthenticationDto;

@Repository
public interface StudentRepository extends JpaRepository<StudentModel, Integer> {

	StudentModel findByEmailId(String loginAuthenticationDto);
}
