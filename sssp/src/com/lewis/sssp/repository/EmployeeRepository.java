package com.lewis.sssp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lewis.sssp.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Integer>{
	Employee getByLastName(String lastName);
}
