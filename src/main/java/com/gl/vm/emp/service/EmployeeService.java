package com.gl.vm.emp.service;
import java.util.List;
import com.gl.vm.emp.entity.Employee;
import com.gl.vm.emp.entity.Role;
import com.gl.vm.emp.entity.User;

public interface EmployeeService {
	

	
		public List<Employee> findAll();
		
		public Employee findById(int theId);
		
		public Employee save(Employee theEmployee);
		
		public void deleteById(int theId);
		
		public List<Employee> searchByFirstName(String firstName);
		
		public List<Employee> sortByFirstNameAsc();
		
		public User saveUser(User user);
		public Role saveRole(Role role);
	
}