package com.gl.vm.emp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gl.vm.emp.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {

}