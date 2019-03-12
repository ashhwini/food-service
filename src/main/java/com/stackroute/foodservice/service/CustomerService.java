package com.stackroute.foodservice.service;

import com.stackroute.foodservice.domain.Customer;
import java.util.List;
import java.util.Optional;

public interface CustomerService {
    Customer addRestaurants(Customer customer);
    List<Customer> getAllRestaurants();
    Optional<Customer> getRestaurantById(int id);
    Customer updateRestaurant(Customer customer, int id);
    void deleteRestaurantById(int id);
}
