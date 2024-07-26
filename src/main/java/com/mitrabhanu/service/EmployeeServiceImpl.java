package com.mitrabhanu.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mitrabhanu.entity.Employee;
import com.mitrabhanu.exception.EmployeeNotFoundException;
import com.mitrabhanu.repo.EmployeeRepository;
import com.mitrabhanu.utils.EMployeeUtils;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
	private EmployeeRepository repo;
	
    @Autowired
    private EMployeeUtils util;
    
	public Integer createEmployee(Employee e) {
		
		util.calculateData(e);
		repo.save(e);
		return e.getEmpId();
	}

	public List<Employee> getAllEmployees() {
		return repo.findAll();
	}

	public Employee getOneEmployee(Integer id) throws Exception {
		Optional<Employee> findById = repo.findById(id);
		
		if(findById.isPresent()) {
		    return findById.get();
		}
		else {
			throw new EmployeeNotFoundException("Employee '"+id+"' not available");
		}
	}

	public void deleteEmployee(Integer id) throws Exception {
		repo.delete(getOneEmployee(id));
	}

	public void updateEmployee(Integer id) throws Exception {
		Employee employee = getOneEmployee(id);
		
		util.calculateData(employee);
		repo.save(employee);
		
		/*if(id != null && repo.existsById(id)) {
			util.calculateData(employee);
			repo.save(employee);
		}
		else {
			throw new EmployeeNotFoundException("Employee '"+id+"' not found");
		}*/

	}

	public void updateEmployeeName(String name, Integer id) throws Exception {
        
		if(repo.existsById(id)) {
			repo.updateEmpName(name, id);
		}
		else {
			throw new EmployeeNotFoundException("Employee '"+id+"' not exist..!");
		}
	}

}
