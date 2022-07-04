package com.employee.service;

import java.util.List;
import java.util.Optional;

import com.employee.entity.EmployeeEntity;

public interface EmployeeService {

	Integer saveEmployee(EmployeeEntity employee);

	public List<EmployeeEntity> getAllEmployee();

	Optional<EmployeeEntity> getEmployee(Integer id);

	public void deleteEmployee(Integer id);

	Integer updateEmployee(EmployeeEntity employeeEntity, Integer id);

}
