package com.mohirdev.CRM_mohirdev.Service;

import com.mohirdev.CRM_mohirdev.Repository.DepartmentRepository;
import com.mohirdev.CRM_mohirdev.model.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository repository;

    public Department getDepartment(Long id) {
        return repository.findById(id).get();
    }

    public List<Department> getAllDepartments() {
        return repository.findAll();
    }

    public  void deleteDepartment(Long id) {
        repository.deleteById(id);
    }

    public Department saveDepartment(Department department) {
        return repository.save(department);
    }

    public Department updateDepartment(Department department, Long id) {
        Department result = repository.findById(id).get();
        result.setDepartment_id(department.getDepartment_id());
        result.setDepartment_name(department.getDepartment_name());
        return repository.save(result);
    }

}
