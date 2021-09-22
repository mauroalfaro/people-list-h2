package com.alfarosoft.peoplelist.service;

import com.alfarosoft.peoplelist.model.Customer;
import com.alfarosoft.peoplelist.model.Store;
import com.alfarosoft.peoplelist.repository.CustomerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class CustomerService {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public void saveCustomer (Customer customer){
        customerRepository.save(customer);
    }

    public void deleteCustomerById (String customerId){
        customerRepository.deleteById(customerId);
    }

    public Optional<Customer> lookupCustomer (String customerId){
       return customerRepository.findById(customerId);
    }

    public List<Customer> searchCustomers() {
        return customerRepository.findAll();
    }

    public void updateCustomerbyId (String customerId, Customer customer) {
        if (customerRepository.findById(customerId).isPresent()) {
            Customer customerUpdated = Customer.builder()
                    .id(customerId)
                    .name(customer.getName())
                    .surname(customer.getSurname())
                    .loyaltyId(customer.getLoyaltyId())
                    .address(customer.getAddress())
                    .phone(customer.getPhone())
                    .email(customer.getEmail())
                    .build();
            customerRepository.save(customerUpdated);
        }
    }

}