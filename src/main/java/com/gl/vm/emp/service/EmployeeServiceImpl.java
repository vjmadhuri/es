package com.gl.vm.emp.service;

import java.util.List;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.gl.vm.emp.entity.Employee;
import com.gl.vm.emp.entity.Role;
import com.gl.vm.emp.entity.User;
import com.gl.vm.emp.repository.EmployeeRepository;



@Repository
public class EmployeeServiceImpl implements EmployeeService {

	
	
		@Autowired
		EmployeeRepository employeeRepository;

		@Transactional
		public List<Employee> findAll() {

			List<Employee> employee = employeeRepository.findAll();

			return employee;
		}

		@Transactional
		public Employee findById(int id) {

			Employee employee = new Employee();

			// Find record with Id from the database table
			employee =employeeRepository.findById(id).get();

			return employee;
		}

		@Transactional
		public void save1(Employee theEmployee) {

			employeeRepository.save(theEmployee);

		}

		@Transactional
		public void deleteById(int id) {

			employeeRepository.deleteById(id);

		}

		@Override
		public Employee save(Employee theEmployee) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public List<Employee> searchByFirstName(String firstName) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public List<Employee> sortByFirstNameAsc() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public User saveUser(User user) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Role saveRole(Role role) {
			// TODO Auto-generated method stub
			return null;
		}

	}

