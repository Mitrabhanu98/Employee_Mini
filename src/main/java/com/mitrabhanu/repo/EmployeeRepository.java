package com.mitrabhanu.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.mitrabhanu.entity.Employee;

import jakarta.transaction.Transactional;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	@Modifying
	@Transactional
	@Query("UPDATE Employee SET empName=:name WHERE empId=:id")
	public void updateEmpName(String name, Integer id);
}
