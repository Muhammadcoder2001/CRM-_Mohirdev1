package com.mohirdev.CRM_mohirdev.Controller;

import com.mohirdev.CRM_mohirdev.Service.EmployeeService;
import com.mohirdev.CRM_mohirdev.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("/employees")
    public ResponseEntity<?> create(@RequestBody Employee employee) {
        Employee result = employeeService.createEmployee(employee);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/employees")
    public ResponseEntity<?> getAll() {
        List<Employee> result = employeeService.getAllEmployees();
        return ResponseEntity.ok(result);
    }

    @GetMapping("/employees/{id}")
    public ResponseEntity<?> getEmployee(@PathVariable Long id) {
        Employee result = employeeService.getEmployee(id);
        return ResponseEntity.ok(result);
    }

    @PutMapping("/employees/{id}")
    public ResponseEntity<?> update(@RequestBody Employee employee, Long id) {
        Employee result = employeeService.updateEmployee(id, employee);
        return ResponseEntity.ok(result);
    }

//    @GetMapping("/employees/search")
//    public ResponseEntity<?> search(@RequestParam String keyword) {
//        List<Employee> employees = employeeService.getByParam(keyword);
//        return ResponseEntity.ok(employees);
//    }

    @DeleteMapping("/employees/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
        return ResponseEntity.ok("Employee is deleted");
    }

}
