package com.alfarosoft.peoplelist.service;

import com.alfarosoft.peoplelist.model.Customer;
import com.alfarosoft.peoplelist.model.Employee;
import com.alfarosoft.peoplelist.repository.CustomerRepository;
import com.alfarosoft.peoplelist.repository.EmployeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public void saveEmployee (Employee employee){
        employeeRepository.save(employee);
    }

    public void deleteEmployeeById (String employeeId){
        employeeRepository.deleteById(employeeId);
    }

    public Optional<Employee> lookupEmployee (String employeeId){
        return employeeRepository.findById(employeeId);
    }

    public List<Employee> searchEmployees() {
        return employeeRepository.findAll();
    }

    public void updateEmployeeById (String employeeId, Employee employee) {
        if (employeeRepository.findById(employeeId).isPresent()) {
            Employee employeeUpdated = Employee.builder()
                    .id(employeeId)
                    .name(employee.getName())
                    .name(employee.getSurname())
                    .address(employee.getAddress())
                    .phone(employee.getPhone())
                    .email(employee.getEmail())
                    .dateHired(employee.getDateHired())
                    .isActiveEmployee(employee.isActiveEmployee())
                    .build();
            employeeRepository.save(employeeUpdated);
        }
    }
}
