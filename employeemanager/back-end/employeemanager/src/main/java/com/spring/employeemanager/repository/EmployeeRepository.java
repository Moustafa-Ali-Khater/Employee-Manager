package com.spring.employeemanager.repository;

import com.spring.employeemanager.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    Optional<Employee> findEmployeeById(Long id);
}
