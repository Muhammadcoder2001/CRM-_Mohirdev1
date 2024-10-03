package com.mohirdev.CRM_mohirdev.Service;

import com.mohirdev.CRM_mohirdev.Repository.EmployeeRepository;
import com.mohirdev.CRM_mohirdev.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository repository;

    public Employee createEmployee(Employee employee) {
        return repository.save(employee);
    }
    public Employee getEmployee(Long id) {
        return repository.findById(id).get();
    }

    public List<Employee> getAllEmployees() {
        return repository.findAll();
    }

    public Employee updateEmployee(Long id, Employee employee) {
        Employee result = repository.findById(id).get();
        result.setName(employee.getName());
        result.setSalary(employee.getSalary());
        result.setAddress(employee.getAddress());
        result.setDepartment(employee.getDepartment());
        result.setAddress(employee.getAddress());
        result.setAge(employee.getAge());
        result.setPassport(employee.getPassport());
        result.setRoles(employee.getRoles());
        result.setLast_name(employee.getLast_name());
        result.setSurname(employee.getSurname());
        return repository.save(result);

    }

    public List<Employee> getEmployeeByLastName(String keyword) {
        return repository.findByParam(keyword);
    }

    public void deleteEmployee(Long id) {
        repository.deleteById(id);
    }

}
