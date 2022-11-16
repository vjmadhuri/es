package com.gl.vm.emp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
public class EmployeeMsystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeMsystemApplication.class, args);
	}

}
