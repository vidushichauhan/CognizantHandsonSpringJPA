package com.cognizant.ormlearnh2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cognizant.ormlearnh2.model.Department;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {

}
