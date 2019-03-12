package com.stackroute.foodservice.service;

import com.stackroute.foodservice.domain.Customer;
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
    public Customer addRestaurants(Customer customer) {
        Customer savedRestaurant = customerRepository.save(customer);
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
        Customer updateUser =  customerRepository.save(customer);
        return updateUser;
    }

    @Override
    public void deleteRestaurantById(int id) {
        customerRepository.deleteById(id);
    }

}
