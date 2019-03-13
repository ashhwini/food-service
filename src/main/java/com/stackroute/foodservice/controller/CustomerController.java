package com.stackroute.foodservice.controller;

import com.stackroute.foodservice.domain.Customer;
import com.stackroute.foodservice.exceptions.UserAlreadyExistsException;
import com.stackroute.foodservice.exceptions.UserNotFoundException;
import com.stackroute.foodservice.service.CustomerService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
@Api(value = "foodservice", description = "Operations pertaining to restaurant details")
public class CustomerController {

    private CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping("/customer")
    public ResponseEntity<Customer> saveRestaurant(@RequestBody Customer customer) throws UserAlreadyExistsException {
        ResponseEntity responseEntity;
        customerService.addRestaurants(customer);
        responseEntity = new ResponseEntity<String>("Sucessfully created", HttpStatus.CREATED);
        return responseEntity;
    }

    @GetMapping("/customers")
    public ResponseEntity<List<Customer>> getAllRestaurant(@RequestBody Customer user) {
        return new ResponseEntity<List<Customer>>(customerService.getAllRestaurants(), HttpStatus.OK);
    }

    @GetMapping("/customer/{id}")
    public ResponseEntity<Optional<Customer>> getRestaurantById(@PathVariable int id) {
        return new ResponseEntity<Optional<Customer>>(customerService.getRestaurantById(id), HttpStatus.FOUND);
    }

    @GetMapping("/customers/{name}")
    public ResponseEntity<List<Customer>> getRestaurantByName(@PathVariable String name) throws UserNotFoundException {
        ResponseEntity responseEntity;
        responseEntity = new ResponseEntity<List<Customer>>(customerService.getRestaurantByName(name), HttpStatus.FOUND);
        return responseEntity;
    }

    @PutMapping("/customer/{id}")
    public ResponseEntity<Customer> updateRestaurantDetails(@PathVariable int id, @RequestBody Customer customer) {
        Customer updateUser = customerService.updateRestaurant(customer, id);
        return new ResponseEntity<Customer>(updateUser, HttpStatus.OK);
    }

    @DeleteMapping("/customer/{id}")
    public void deleteRestaurantById(@PathVariable int id) {
        customerService.deleteRestaurantById(id);
    }

}
