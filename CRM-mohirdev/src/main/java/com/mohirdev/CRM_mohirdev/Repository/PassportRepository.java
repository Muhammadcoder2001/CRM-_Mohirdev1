package com.mohirdev.CRM_mohirdev.Repository;

import com.mohirdev.CRM_mohirdev.model.Passport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PassportRepository extends JpaRepository<Passport, Long> {

}