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

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @PostMapping("/departments")
    public ResponseEntity<?> addDepartment(@RequestBody Department department) {
        Department result = departmentService.saveDepartment(department);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/departments")
    public ResponseEntity<?> getAllDepartments() {
        List<Department> result = departmentService.getAllDepartments();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/departments/{id}")
    public ResponseEntity<?> getDepartmentById(@PathVariable Long id) {
        Department result = departmentService.getDepartment(id);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PutMapping("/departments/{department_id}")
    public ResponseEntity<?> updateDepartment(@RequestBody Department department, @PathVariable Long department_id) {
        Department result = departmentService.updateDepartment(department, department_id);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }


    @DeleteMapping("/department/{id}")
    public ResponseEntity<?> deleteDepartment(@PathVariable Long id) {
        departmentService.deleteDepartment(id);
        return new ResponseEntity<>("User is deleted",HttpStatus.OK);
    }
}
