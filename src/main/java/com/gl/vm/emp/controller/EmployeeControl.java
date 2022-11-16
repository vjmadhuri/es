package com.gl.vm.emp.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.gl.vm.emp.entity.Employee;
import com.gl.vm.emp.service.EmployeeService;


@RestController
@RequestMapping("/employee")
public class EmployeeControl {

	@Autowired
	private EmployeeService employeeService;

	// Add mapping for "/list"
	@RequestMapping("/list")
	public String listEmployee(Model theModel) {

		// Get EMPLOYEE from Database
		List<Employee> theEmployee = employeeService.findAll();
		
		// Add to the spring model
		theModel.addAttribute("Employee", theEmployee);

		return "list-Employees";
	}

	@RequestMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {

		// create model attribute to bind form data
		Employee theEmployee = new Employee();

		theModel.addAttribute("Employees", theEmployee);

		return "Employee-form";
	}

	@RequestMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("employeeId") int theId,
			Model theModel) {

		// get the Book from the service
		Employee theEmployee = employeeService.findById(theId);


		// set Book as a model attribute to pre-populate the form
		theModel.addAttribute("Employee", theEmployee);

		// send over to our form
		return "Employee-form";			
	}

	@PostMapping("/save")
	public String saveBook(@RequestParam("id") int id,
			@RequestParam("firstName") String firstName,@RequestParam("lastName") String lastName,@RequestParam("email") String email) {

		System.out.println(id);
	Employee theEmployee;
		if(id!=0) {
			theEmployee=employeeService.findById(id);
			theEmployee.setFirstName(firstName);
			theEmployee.setLastName(lastName);
			theEmployee.setEmail(email);
			
		}
		else
			theEmployee=new Employee(firstName, lastName, email);
		
		// Save the EMPLOYEE
		employeeService.save(theEmployee);

		// Use a redirect to prevent duplicate submissions
		return "redirect:/employee/list";

	}

	@RequestMapping("/delete")
	public String delete(@RequestParam("employeeId") int theId) {

		// Delete the EMPLOYEE
		employeeService.deleteById(theId);

		// Redirect to /Books/list
		return "redirect:/employee/list";

	}
	@RequestMapping(value = "/403")
	public ModelAndView accesssDenied(Principal user) {

		ModelAndView model = new ModelAndView();

		if (user != null) {
			model.addObject("msg", "Hi " + user.getName() 
			+ ", you do not have permission to access this page!");
		} else {
			model.addObject("msg", 
			"You do not have permission to access this page!");
		}

		model.setViewName("403");
		return model;

	}
	
}
	
		

