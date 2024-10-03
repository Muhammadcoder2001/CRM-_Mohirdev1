package com.mohirdev.CRM_mohirdev.model;


import com.mohirdev.CRM_mohirdev.enumeration.EmployeeRoles;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "mohirdev_employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String surname;
    private String last_name;
    private Integer age;
    @ManyToMany
    @JoinTable(
            name = "dev_employee_project",
            joinColumns = {@JoinColumn(name = "mohirdev_employees_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "passport_id", referencedColumnName = "id")})
    private Set<Passport> passport;
    private Double salary;
    @ManyToOne
    private Department department;
    private String address;
    private EmployeeRoles roles;

}
