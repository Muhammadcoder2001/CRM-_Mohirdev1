package com.mohirdev.CRM_mohirdev.Repository;

import com.mohirdev.CRM_mohirdev.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    @Query("SELECT p FROM Employee p WHERE " +
    " LOWER(p.name) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
    " LOWER(p.last_name) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
    " LOWER(p.surname) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
    " LOWER(p.age) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
    " LOWER(p.roles) LIKE LOWER(CONCAT('%', :keyword, '%') ) OR " +
    " LOWER(p.department) LIKE LOWER(CONCAT('%', :keyword, '%') ) OR " +
    " LOWER(p.id) LIKE LOWER(CONCAT('%', :keyword, '%') ) OR " +
    " LOWER(p.salary) LIKE LOWER(CONCAT('%', :keyword, '%') ) OR " +
    " LOWER(p.address) LIKE LOWER(CONCAT('%', :keyword, '%')) ")
    List<Employee> findByParam(@Param("keyword") String keyword);
}
