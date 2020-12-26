package com.demos.jpajoins.springdatajpamapping.repository;

import com.demos.jpajoins.springdatajpamapping.dto.OrderResponse;
import com.demos.jpajoins.springdatajpamapping.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    /**
     * SELECT first name, SELECT product name FROM Customer table, specify alias (c) and join with product (p)
     * lengthy instantiation of OrderResponse object tells JPA (or hibernate?) to map those two objects as parameters of OrderResponse
     */
    @Query("SELECT new com.demos.jpajoins.springdatajpamapping.dto.OrderResponse(c.firstName , p.name) FROM Customer c JOIN c.products p")
    public List<OrderResponse> getJoinInformation();
}
