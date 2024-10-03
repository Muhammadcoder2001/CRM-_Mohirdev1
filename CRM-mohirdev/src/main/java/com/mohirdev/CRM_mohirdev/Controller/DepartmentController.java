package com.mohirdev.CRM_mohirdev.Controller;

import com.mohirdev.CRM_mohirdev.Service.DepartmentService;
import com.mohirdev.CRM_mohirdev.model.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class DepartmentController {

    @Autowired
    private DepartmentService service;

    @PostMapping("/departments")
    public ResponseEntity<?> addDepartment(@RequestBody Department department) {
        Department result = service.saveDepartment(department);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/departments")
    public ResponseEntity<?> getAllDepartments() {
        List<Department> result = service.getAllDepartments();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/departments/{id}")
    public ResponseEntity<?> getDepartmentById(@PathVariable Long id) {
        Department result = service.getDepartment(id);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PutMapping("/departments/{department_id}")
    public ResponseEntity<?> updateDepartment(@RequestBody Department department, @PathVariable Long department_id) {
        Department result = service.updateDepartment(department, department_id);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }


    @DeleteMapping("/department/{id}")
    public ResponseEntity<?> deleteDepartment(@PathVariable Long id) {
        service.deleteDepartment(id);
        return new ResponseEntity<>("User is deleted",HttpStatus.OK);
    }
}
