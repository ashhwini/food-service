package com.stackroute.foodservice.controller;

import com.stackroute.foodservice.domain.Customer;
import com.stackroute.foodservice.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class CustomerController {

    private CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping("/customer")
    public ResponseEntity<Customer> saveUser(@RequestBody Customer customer){
        Customer savedUser = customerService.addRestaurants(customer);
        return new ResponseEntity<Customer>(savedUser, HttpStatus.OK);
    }

    @GetMapping("/customers")
    public ResponseEntity<List<Customer>> getAllUsers(@RequestBody Customer user){
        return new ResponseEntity<List<Customer>>(customerService.getAllRestaurants(),HttpStatus.OK);
    }

    @GetMapping("/customer/{id}")
    public ResponseEntity<Optional<Customer>> getUserById(@PathVariable int id) {
        return new ResponseEntity<Optional<Customer>>(customerService.getRestaurantById(id),HttpStatus.OK);
    }
    @PutMapping("/customer/{id}")
    public ResponseEntity<Customer> updateUser(@PathVariable int id,@RequestBody Customer customer){
        Customer updateUser = customerService.updateRestaurant(customer,id);
        return new ResponseEntity<Customer>(updateUser,HttpStatus.OK);
    }
    @DeleteMapping("/customer/{id}")
    public void deleteUserById(@PathVariable int id)
    {
        customerService.deleteRestaurantById(id);
    }

}
