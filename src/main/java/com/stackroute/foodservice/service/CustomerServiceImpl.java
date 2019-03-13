package com.stackroute.foodservice.service;
/*
Here those CRUD operations are implemented.
Each customer or app-user can fetch details of different restaurants from his account
 */

import com.stackroute.foodservice.domain.Customer;
import com.stackroute.foodservice.exceptions.UserAlreadyExistsException;
import com.stackroute.foodservice.exceptions.UserNotFoundException;
import com.stackroute.foodservice.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    private CustomerRepository customerRepository;

    public CustomerServiceImpl() {
    }

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer addRestaurants(Customer customer) throws UserAlreadyExistsException {

        if (customerRepository.existsById(customer.getRestaurantId())) {
            throw new UserAlreadyExistsException("User Already Exists");
        }
        Customer savedRestaurant = customerRepository.save(customer);
        if (savedRestaurant == null) {
            throw new UserAlreadyExistsException("User Already Exists");
        }
        return savedRestaurant;
    }

    @Override
    public List<Customer> getAllRestaurants() {
        return (List<Customer>) customerRepository.findAll();
    }

    @Override
    public Optional<Customer> getRestaurantById(int id) {
        return customerRepository.findById(id);
    }

    @Override
    public Customer updateRestaurant(Customer customer, int id) {
        customer.setRestaurantId(id);
        Customer updateUser = customerRepository.save(customer);
        return updateUser;
    }

    @Override
    public void deleteRestaurantById(int id) {
        customerRepository.deleteById(id);
    }

    @Override
    public List<Customer> getRestaurantByName(String name) throws UserNotFoundException {
        List<Customer> restaurant = customerRepository.findByName(name);
        if (restaurant.isEmpty()) {
            throw new UserNotFoundException("User Not Found");
        }
        return restaurant;
    }
}
