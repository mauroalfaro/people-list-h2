package com.alfarosoft.peoplelist.repository;

import com.alfarosoft.peoplelist.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, String> {
}
