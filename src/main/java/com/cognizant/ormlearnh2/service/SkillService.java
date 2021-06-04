package com.cognizant.ormlearnh2.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.ormlearnh2.model.Skill;
import com.cognizant.ormlearnh2.repository.SkillRepository;

@Service
public class SkillService {
	//private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeService.class);
    @Autowired
	private SkillRepository skillRepository;
	@Transactional
	public Skill get(int id) {

	//LOGGER.info("Start");

	return skillRepository.findById(id).get();

	}
	
	@Transactional

	public void save(Skill skill) {

	//LOGGER.info("Start");

	skillRepository.save(skill);

	//LOGGER.info("End");

	}
}
