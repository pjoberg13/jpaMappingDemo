package com.demos.jpajoins.springdatajpamapping.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Customer {

    @Id
    @GeneratedValue
    private Long id;

    private String firstName;
    private String lastName;
    private String email;
    private String gender;
    private Date dateOfBirth;

    /**
     * One customer can have many products
     * target entity and cascase type must be specified
     * join column must be specified
     */
    @OneToMany(targetEntity = Product.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "cp_foreignKey", referencedColumnName = "id")
    private List<Product> products;
}
