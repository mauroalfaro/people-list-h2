package com.alfarosoft.peoplelist.controller;

import com.alfarosoft.peoplelist.model.Customer;
import com.alfarosoft.peoplelist.model.patch.CustomerPatch;
import com.alfarosoft.peoplelist.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/customer")
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping(value = "/add", consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<?> saveCustomer (@RequestBody Customer customer){
        customerService.saveCustomer(customer);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping(value = "/{id}", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<Customer> lookupCustomer (@PathVariable String id){
        if(customerService.lookupCustomer(id).isPresent()){
            return ResponseEntity.status(HttpStatus.OK).body(customerService.lookupCustomer(id).get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Customer>> searchCustomers (){
        return ResponseEntity.status(HttpStatus.OK).body(customerService.searchCustomers());
    }

    @PutMapping(value = "/{id}", consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<?> updateCustomer (@PathVariable String id, @RequestBody Customer customer){
        customerService.updateCustomerbyId(id, customer);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> patchCustomer (@PathVariable String id, @RequestBody CustomerPatch customerPatch) {
        customerService.patchCustomerById(id, customerPatch);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteCustomer (@PathVariable String id){
        customerService.deleteCustomerById(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<String> handleException(final EntityNotFoundException e){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }
}
