package com.mitrabhanu.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mitrabhanu.entity.Employee;
import com.mitrabhanu.exception.EmployeeNotFoundException;
import com.mitrabhanu.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeRestcontroller {

	@Autowired
	private EmployeeService service;
	
	@PostMapping("/create")
	public ResponseEntity<String> createEmployee(@RequestBody Employee employee) {
		Integer empId = service.createEmployee(employee);
		String message = "Employee '"+empId+"' created";
		return new ResponseEntity<String>(message, HttpStatus.CREATED);
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Employee>> getAllEmployees() {
		List<Employee> employees = service.getAllEmployees();
		return new ResponseEntity<List<Employee>>(employees, HttpStatus.OK);
	}
	
	@GetMapping("/one/{id}")
	public ResponseEntity<?> getOneEmployee(@PathVariable Integer id) throws Exception {

		ResponseEntity<?> response = null;
		
		try {
			Employee employee = service.getOneEmployee(id);
			response = new ResponseEntity<Employee>(employee, HttpStatus.OK);
			
		} catch (EmployeeNotFoundException e) {
			response = new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return response;
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<String> updateEmployee(@PathVariable Integer id) throws Exception {
		ResponseEntity<String> response = null;
		
		try {
			service.updateEmployee(id);
			response = new ResponseEntity<String>("Employee '"+id+"' updated successfully", HttpStatus.OK);
		} catch (EmployeeNotFoundException e) {
			response = new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return response;
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable Integer id) throws Exception {
		ResponseEntity<String> response = null;
		
		try {
			service.deleteEmployee(id);
			response =  new ResponseEntity<String>("Employee '"+id+"' deleted..!", HttpStatus.OK);
		} 
		catch (EmployeeNotFoundException e) {
			response = new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return response;
	}
	
	@PatchMapping("/update/{name}/{id}")
	public ResponseEntity<String> updateEmployeeName(@PathVariable String name, 
			                                         @PathVariable Integer id
			                                         ) throws Exception {
		ResponseEntity<String> response = null;
		try {
			service.updateEmployeeName(name, id);
			String message = "Name updated successfully";
			response = new ResponseEntity<String>(message, HttpStatus.OK);
		} 
		catch (EmployeeNotFoundException e) {
			response = new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return response;
	}
	
}
