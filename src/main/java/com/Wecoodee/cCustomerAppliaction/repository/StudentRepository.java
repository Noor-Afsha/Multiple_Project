package com.Wecoodee.cCustomerAppliaction.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.Wecoodee.cCustomerAppliaction.Model.StudentModel;

@Repository
public interface StudentRepository extends CrudRepository<StudentModel, Integer> {


	StudentModel findByName(String name );

	StudentModel findByRollNumber(int rollNumber);

	//StudentModel findByRollNumber(int rollNumber);

	

}
