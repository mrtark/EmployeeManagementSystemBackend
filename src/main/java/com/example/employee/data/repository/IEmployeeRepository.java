package com.example.employee.data.repository;

import com.example.employee.data.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface IEmployeeRepository extends JpaRepository<EmployeeEntity,Long> {
    EmployeeEntity findByTelephoneNumber(String telephoneNumber);
}
