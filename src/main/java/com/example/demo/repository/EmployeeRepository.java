package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Car;
import com.example.demo.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	// Custom methods for employee
	public List<Employee> findByName(String name);

	public List<Employee> findByCollege(String name);

	public List<Employee> getByName(String name);

	public List<Employee> queryByName(String name);

	public List<Employee> findByNameAndCollege(String name1, String college1);

	public List<Employee> countByName(String name2);

	// custom query for employee

	// @Query("select distinct roleId from UserRole where roleId=:roleId")// to
	// remove duplicate

	@Query("select distinct name from Employee where name=:name")
	List<String> getAllName(@Param("name") String name);

}
