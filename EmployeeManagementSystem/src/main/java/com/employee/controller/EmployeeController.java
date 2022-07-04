package com.employee.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.employee.entity.EmployeeEntity;
import com.employee.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	@PostMapping(value = "/saveEmployee")
	public Integer saveStudet(@RequestBody EmployeeEntity student) {
		Integer id = employeeService.saveEmployee(student);
		System.out.println("student id" + id);
		return id;

	}

	@GetMapping(value = "/getAllEmployee")
	public List<EmployeeEntity> getAllStudents() {

		return employeeService.getAllEmployee();
	}

	@GetMapping(value = "/employee/{id}")
	public Optional<EmployeeEntity> getStudent(@PathVariable Integer id) {

		// Optional<EmployeeEntity> student=employeeService.getStudent(id);

		return employeeService.getEmployee(id);
	}

	@DeleteMapping(value = "employee/{id}")
	public ResponseEntity<EmployeeEntity> deleteStudent(@PathVariable Integer id) {

		ResponseEntity<EmployeeEntity> response = new ResponseEntity<>(HttpStatus.OK);

		try {
			employeeService.deleteEmployee(id);
		} catch (Exception e) {
			response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return response;
	}

	@PutMapping(value = "updateEmployee/{id}")
	public ResponseEntity<EmployeeEntity> updateStudent(@PathVariable Integer id,
			@RequestBody EmployeeEntity employeeEntity) {

		ResponseEntity<EmployeeEntity> response = new ResponseEntity<>(HttpStatus.OK);

		try {
			employeeService.updateEmployee(employeeEntity, id);
		} catch (Exception e) {
			response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return response;
	}

}
