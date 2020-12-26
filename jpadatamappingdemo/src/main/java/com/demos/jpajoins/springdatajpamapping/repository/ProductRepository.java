package com.demos.jpajoins.springdatajpamapping.repository;

import com.demos.jpajoins.springdatajpamapping.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
