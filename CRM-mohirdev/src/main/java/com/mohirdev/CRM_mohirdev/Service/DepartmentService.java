package com.mohirdev.CRM_mohirdev.Service;

import com.mohirdev.CRM_mohirdev.Repository.DepartmentRepository;
import com.mohirdev.CRM_mohirdev.model.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {

    private final DepartmentRepository departmentRepository;

    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    public Department getDepartment(Long id) {
        return departmentRepository.findById(id).get();
    }

    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    public  void deleteDepartment(Long id) {
        departmentRepository.deleteById(id);
    }

    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    public Department updateDepartment(Department department, Long id) {
        Department result = departmentRepository.findById(id).get();
        result.setDepartment_id(department.getDepartment_id());
        result.setDepartment_name(department.getDepartment_name());
        return departmentRepository.save(result);
    }

}
