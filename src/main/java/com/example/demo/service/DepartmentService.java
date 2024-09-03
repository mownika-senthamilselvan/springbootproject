package com.example.demo.service;


import java.util.List;

import com.example.demo.entity.Department;
import com.example.demo.error.DepartmentNotFoundException;


public interface DepartmentService {
     
	public Department saveDepartment(Department deparment);
	public List<Department> fetchDepartmentList();
	public Department findDepartmentId(Long id) throws DepartmentNotFoundException;
	public void deleteDepartmentId(Long id);
	public Department updateDepartment(Long id,Department department);
	public Department fecthDepartmentByName(String departmentName);
}
