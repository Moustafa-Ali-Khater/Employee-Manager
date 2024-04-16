package com.spring.employeemanager.controller;

import com.spring.employeemanager.model.Employee;
import com.spring.employeemanager.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
@RequiredArgsConstructor
public class EmpolyeeController {

   private final EmployeeService employeeService;

    /*public EmpolyeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }*/

    @GetMapping("/all")
    public ResponseEntity<List<Employee>> getAllEmployee() {
       List<Employee> employees = employeeService.findAllEmployee();
       return new ResponseEntity<>(employees, HttpStatus.OK);
   }

    @GetMapping("/find/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") Long id) {
       Employee employee = employeeService.findEmployeeById(id);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
        Employee addemployee = employeeService.addEmpolyee(employee);
        return new ResponseEntity<>(addemployee, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Employee> updarteEmployee(@RequestBody Employee employee) {
        Employee updateemployee = employeeService.addEmpolyee(employee);
        return new ResponseEntity<>(updateemployee, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteEmployeeById(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
         return new ResponseEntity<>(HttpStatus.OK);
    }
}
