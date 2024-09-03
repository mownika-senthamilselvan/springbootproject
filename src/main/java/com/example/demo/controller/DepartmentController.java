package com.example.demo.controller;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Department;
import com.example.demo.error.DepartmentNotFoundException;
import com.example.demo.service.DepartmentService;

import jakarta.validation.Valid;

@RestController
public class DepartmentController {
	
	@Autowired
	private DepartmentService departmentService;
	
	private final Logger LOGGER=LoggerFactory.getLogger(DepartmentController.class);
			
			  
	
	@PostMapping("/departments")
	public Department saveDepartment(@Valid@RequestBody Department department) {
		LOGGER.info("Details is insert");
		 return departmentService.saveDepartment(department);
	}
	
	@GetMapping("/departments")
	public List<Department> fetchDepartmentList(){
		LOGGER.info("FetchDepartMentList in Table");
		return departmentService.fetchDepartmentList();
	}
	
	@GetMapping("/departments/{departmentID}")
	public Department findDepartmentId(@PathVariable("departmentID") Long id) throws DepartmentNotFoundException {
		return departmentService.findDepartmentId(id);
	}
	
	@DeleteMapping("/departments/{departmentID}")
	public String deleteDepartmentId(@PathVariable("departmentID") Long id) {
		 departmentService.deleteDepartmentId(id);
		 return "Department Deleted Successfully";
	}
	
	@PutMapping("/departments/{departmentID}")
	public Department updateDepartment(@PathVariable("departmentID") Long id,
			                              @RequestBody Department department) {
		return departmentService.updateDepartment(id,department);
	}
	
	
	@GetMapping("/departments/name/{name}")
	public Department fecthDepartmentByName(@PathVariable("name") String departmentName) {
		return departmentService.fecthDepartmentByName(departmentName);
		
	}

}
