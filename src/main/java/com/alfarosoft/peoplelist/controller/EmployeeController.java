package com.alfarosoft.peoplelist.controller;

import com.alfarosoft.peoplelist.model.Employee;
import com.alfarosoft.peoplelist.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping(value = "/add", consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<?> saveEmployee (@RequestBody Employee employee){
        employeeService.saveEmployee(employee);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping(value = "/{id}", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<Employee> lookupEmployee (@PathVariable String id){
        if(employeeService.lookupEmployee(id).isPresent()){
            return ResponseEntity.status(HttpStatus.OK).body(employeeService.lookupEmployee(id).get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Employee>> searchEmployees (){
        return ResponseEntity.status(HttpStatus.OK).body(employeeService.searchEmployees());
    }

    @PutMapping(value = "/{id}", consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<?> updateEmployee (@PathVariable String id, @RequestBody Employee employee){
        employeeService.updateEmployeeById(id, employee);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteEmployee (@PathVariable String id){
        employeeService.deleteEmployeeById(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<String> handleException(final EntityNotFoundException e){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }
}
