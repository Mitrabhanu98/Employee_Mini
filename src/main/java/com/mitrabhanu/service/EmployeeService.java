package com.mitrabhanu.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mitrabhanu.entity.Employee;

@Service
public interface EmployeeService {

	public Integer createEmployee(Employee e);
	public List<Employee> getAllEmployees();
	public Employee getOneEmployee(Integer id) throws Exception;
	public void deleteEmployee(Integer id) throws Exception;
	public void updateEmployee(Integer id) throws Exception;
    public void updateEmployeeName(String name, Integer id) throws Exception;
}
