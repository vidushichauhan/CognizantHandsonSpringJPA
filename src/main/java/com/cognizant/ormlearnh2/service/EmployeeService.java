package com.cognizant.ormlearnh2.service;

import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.ormlearnh2.model.Employee;
import com.cognizant.ormlearnh2.repository.EmployeeRepository;


@Service
public class EmployeeService {
	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeService.class);
    @Autowired
	private EmployeeRepository employeeRepository;
	
	@Transactional
	public Employee get(int id) {

	LOGGER.info("Start get part");

	return employeeRepository.findById(id).get();
	

	}
	
	@Transactional
	public void save(Employee employee) {

	LOGGER.info("Start save part");
    
	employeeRepository.save(employee);

	LOGGER.info("End save part");

	}
    
	public List<Employee> getAllPermanentEmployees() {
		return employeeRepository.getAllPermanentEmployees();
	}
	
	public double getAverageSalaryService() {
		return employeeRepository.getAverageSalary();
		
	};


}



