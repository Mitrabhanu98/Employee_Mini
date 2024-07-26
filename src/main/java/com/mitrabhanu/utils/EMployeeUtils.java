package com.mitrabhanu.utils;

import org.springframework.stereotype.Component;

import com.mitrabhanu.entity.Employee;

@Component
public class EMployeeUtils {

	public void calculateData(Employee e) {
		Double sal = e.getSal();
		Double hra = sal*20/100;
		Double ta = sal*10/100;

	    e.setHra(hra);
	    e.setTa(ta);
	}	
}
