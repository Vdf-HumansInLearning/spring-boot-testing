package com.vdf.demo.controller;

import com.vdf.demo.model.Employee;
import com.vdf.demo.persistence.EmployeeRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @PostMapping("/")
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
        return new ResponseEntity<>(employeeRepository.save(employee), HttpStatus.CREATED);
    }

    @GetMapping("/")
    public ResponseEntity<List<Employee>> getEmployees(@RequestParam(required = false, name = "lastName") String lastName) {
        if(lastName != null) {
            return new ResponseEntity<>(employeeRepository.findByLastNameContainingIgnoreCase(lastName), HttpStatus.OK);
        }
        return new ResponseEntity<>(employeeRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        return employee.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
            .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
