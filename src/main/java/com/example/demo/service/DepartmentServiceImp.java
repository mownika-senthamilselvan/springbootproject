package com.example.demo.service;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;


import com.example.demo.entity.Department;
import com.example.demo.error.DepartmentNotFoundException;
import com.example.demo.repository.DepartmentRepository;

@Service
public class DepartmentServiceImp implements DepartmentService{
	
	@Autowired
	private DepartmentRepository departmentRespository;
	
    @Override 
	public Department saveDepartment(Department deparment) {
		return departmentRespository.save(deparment);
	}

	@Override
	public List<Department> fetchDepartmentList() {
		// TODO Auto-generated method stub
		return departmentRespository.findAll();
	}

	@Override
	public Department findDepartmentId(Long id) throws DepartmentNotFoundException {
        
		Optional<Department> department=departmentRespository.findById(id);
		if(!department.isPresent()) {
			throw new DepartmentNotFoundException("Department Not Found");
		}
		
		  return  department.get();
	}

	@Override
	public void deleteDepartmentId(Long id) {
		departmentRespository.deleteById(id);
	}

	@Override
	public Department updateDepartment(Long id, Department department) {
		Department depDB=departmentRespository.findById(id).get();
		
		if(Objects.nonNull(department.getDepartmentName()) &&
		        !"".equalsIgnoreCase(department.getDepartmentName())) 
		{
		            depDB.setDepartmentName(department.getDepartmentName());
		        }
		
		if(Objects.nonNull(department.getDepartmentCode()) &&
                !"".equalsIgnoreCase(department.getDepartmentCode())) {
            depDB.setDepartmentCode(department.getDepartmentCode());
        }
		

		if(Objects.nonNull(department.getDepartmentAddress()) &&
		        !"".equalsIgnoreCase(department.getDepartmentAddress())) 
		{
		            depDB.setDepartmentAddress(department.getDepartmentAddress());
		        }
		
		return departmentRespository.save(depDB);
	}

	@Override
	public Department fecthDepartmentByName(String departmentName) {
		// TODO Auto-generated method stub
		return departmentRespository.findAllBydepartmentName(departmentName);
	}

	
	
	
    
    
}
