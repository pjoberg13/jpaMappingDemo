package com.demos.jpajoins.springdatajpamapping.controller;

import com.demos.jpajoins.springdatajpamapping.entity.Customer;
import com.demos.jpajoins.springdatajpamapping.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CustomerController {

    private CustomerRepository customerRepository;

    @Autowired
    public CustomerController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @PostMapping("/customers/create")
    public Customer createCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @DeleteMapping("/customers/delete/{id}")
    public Boolean deleteCustomer(@PathVariable Long id) {
        customerRepository.deleteById(id);
        return true;
    }

    @GetMapping("/customers")
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @GetMapping("/customers/{id}")
    public Optional<Customer> findById(@PathVariable Long id) {
        return customerRepository.findById(id);
    }

}
