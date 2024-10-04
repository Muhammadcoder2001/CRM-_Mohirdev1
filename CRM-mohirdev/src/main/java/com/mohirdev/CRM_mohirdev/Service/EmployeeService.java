package com.mohirdev.CRM_mohirdev.Service;

import com.mohirdev.CRM_mohirdev.Repository.EmployeeRepository;
import com.mohirdev.CRM_mohirdev.model.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepository employeerepository;

    public EmployeeService(EmployeeRepository employeerepository) {
        this.employeerepository = employeerepository;
    }

    public Employee createEmployee(Employee employee) {
        return employeerepository.save(employee);
    }
    public Employee getEmployee(Long id) {
        return employeerepository.findById(id).get();
    }

    public List<Employee> getAllEmployees() {
        return employeerepository.findAll();
    }

    public Employee updateEmployee(Long id, Employee employee) {
        Employee result = employeerepository.findById(id).get();
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
        return employeerepository.save(result);

    }

//    public List<Employee> getByParam(String keyword) {
//        return employeerepository.searchKeyword(keyword);
//    }

    public void deleteEmployee(Long id) {
        employeerepository.deleteById(id);
    }

}
