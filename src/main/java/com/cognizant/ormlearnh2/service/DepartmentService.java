package com.cognizant.ormlearnh2.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.ormlearnh2.model.Department;
import com.cognizant.ormlearnh2.repository.DepartmentRepository;

@Service
public class DepartmentService {
	//private static final Logger LOGGER = LoggerFactory.getLogger(DepartmentService.class);
    @Autowired
	private DepartmentRepository DepartmentRepository;

    @Transactional

	public Department get(int id) {

	//LOGGER.info("Start");

	return DepartmentRepository.findById(id).get();

	}
	
	@Transactional

	public void save(Department department) {

	//LOGGER.info("Start");

	DepartmentRepository.save(department);

	//LOGGER.info("End");

	}
}
