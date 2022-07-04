package com.employee.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.entity.EmployeeEntity;
import com.employee.exception.ResourceNotFoundException;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	EmployeeRepository employeeRepo;
	@Override
	public Integer saveEmployee(EmployeeEntity employee) {
		EmployeeEntity saveStudent = employeeRepo.save(employee);
		return saveStudent.getId();
		// TODO Auto-generated method stub
	}

	@Override
	public List<EmployeeEntity> getAllEmployee() {
		// TODO Auto-generated method stub
		return employeeRepo.findAll();
	}

	@Override
	public Optional<EmployeeEntity> getEmployee(Integer id) {
		Optional<EmployeeEntity> employee = employeeRepo.findById(id);
		// TODO Auto-generated method stub
		return employee;
	}

	@Override
	public void deleteEmployee(Integer id) {
		employeeRepo.deleteById(id);
		// TODO Auto-generated method stub

	}

	@Override
	public Integer updateEmployee(EmployeeEntity employeeEntity, Integer id) {
		EmployeeEntity existingEmployee=employeeRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Employee","id",id));
		existingEmployee.setName(employeeEntity.getName());
		existingEmployee.setDesignation(employeeEntity.getDesignation());
		employeeRepo.save(existingEmployee);		
		return existingEmployee.getId();
		// TODO Auto-generated method stub
	}

}
