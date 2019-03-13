package com.stackroute.foodservice.repository;

import com.stackroute.foodservice.domain.Customer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends CrudRepository<Customer,Integer> {
    @Query(value = "select customer from Customer customer where customer.restaurantName = ?1")
    List<Customer> findByName(String name);
}

