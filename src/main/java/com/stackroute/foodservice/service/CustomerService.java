package com.stackroute.foodservice.service;
/*
    Interface which has all the CRUD operations's method signature
 */
import com.stackroute.foodservice.domain.Customer;
import com.stackroute.foodservice.exceptions.UserAlreadyExistsException;
import com.stackroute.foodservice.exceptions.UserNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface CustomerService {
    Customer addRestaurants(Customer customer) throws UserAlreadyExistsException;

    List<Customer> getAllRestaurants();

    Optional<Customer> getRestaurantById(int id);

    Customer updateRestaurant(Customer customer, int id);

    void deleteRestaurantById(int id);

    List<Customer> getRestaurantByName(String name) throws UserNotFoundException;
}
