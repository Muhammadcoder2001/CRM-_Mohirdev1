package com.mohirdev.CRM_mohirdev.Controller;

import com.mohirdev.CRM_mohirdev.Service.EmployeeService;
import com.mohirdev.CRM_mohirdev.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {
    @Autowired
    private EmployeeService service;

    @PostMapping("/employees")
    public ResponseEntity<?> create(@RequestBody Employee employee) {
        Employee result = service.createEmployee(employee);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/employees")
    public ResponseEntity<?> getAll() {
        List<Employee> result = service.getAllEmployees();
        return ResponseEntity.ok(result);
    }

    @GetMapping("/employees/{id}")
    public ResponseEntity<?> getEmployee(@PathVariable Long id) {
        Employee result = service.getEmployee(id);
        return ResponseEntity.ok(result);
    }

    @PutMapping("/employees/{id}")
    public ResponseEntity<?> update(@RequestBody Employee employee, Long id) {
        Employee result = service.updateEmployee(id, employee);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/employees/search")
    public ResponseEntity<?> search(@RequestParam String keyword) {
        List<Employee> result =

    }

}
