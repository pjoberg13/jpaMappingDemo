package com.demos.jpajoins.springdatajpamapping.controller;

import com.demos.jpajoins.springdatajpamapping.dto.OrderRequest;
import com.demos.jpajoins.springdatajpamapping.dto.OrderResponse;
import com.demos.jpajoins.springdatajpamapping.entity.Customer;
import com.demos.jpajoins.springdatajpamapping.repository.CustomerRepository;
import com.demos.jpajoins.springdatajpamapping.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderController {

    private CustomerRepository customerRepository;
    private ProductRepository productRepository;

    @Autowired
    public OrderController(CustomerRepository customerRepository, ProductRepository productRepository) {
        this.customerRepository = customerRepository;
        this.productRepository = productRepository;
    }

    @PostMapping("/placeOrder")
    public Customer placeOrder(@RequestBody OrderRequest request) {
        return customerRepository.save(request.getCustomer());
    }

    @GetMapping("/findAllOrders")
    public List<Customer> findAllCustomers() {
        return customerRepository.findAll();
    }

    @GetMapping("/getJoinInfo")
    public List<OrderResponse> getJoinInformation() {
        return customerRepository.getJoinInformation();
    }
}
