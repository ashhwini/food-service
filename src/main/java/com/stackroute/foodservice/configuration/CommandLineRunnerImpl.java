package com.stackroute.foodservice.configuration;
/*
 Created seed data to pre-fill the database with restaurant information,
 whenever the application starts by using CommandLineRunner Approach
 */

import com.stackroute.foodservice.domain.Customer;
import com.stackroute.foodservice.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {
    private CustomerRepository customerRepository;
    /*
    Removed all hard coded data from the application code to application.properties,
    by using @Value
     */
    @Value("${restaurantId2}")
    int restaurantId;
    @Value("${restaurantName2}")
    String restaurantName;
    @Value("${address2}")
    String address;
    @Value("${city2}")
    String city;

    @Autowired
    public CommandLineRunnerImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    @Order(2)
    public void run(String... args) throws Exception {
        customerRepository.save(new Customer(restaurantId, restaurantName, address, city));
    }
}


