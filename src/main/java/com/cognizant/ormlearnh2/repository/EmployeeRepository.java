package com.cognizant.ormlearnh2.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cognizant.ormlearnh2.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	//@Query(value="SELECT e FROM Employee e WHERE e.permanent = 1")
	@Query(value="SELECT e FROM Employee e left join fetch e.department d left join fetch e.skillList WHERE e.permanent = 1")
	List<Employee> getAllPermanentEmployees();
	
	@Query(value="SELECT AVG(e.salary) FROM Employee e")
	double getAverageSalary();
	
}
