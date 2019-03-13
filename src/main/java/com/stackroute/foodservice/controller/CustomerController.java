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
@RequestMapping("/api/v1") @Api(value="foodservice", description="Operations pertaining to restaurant details")
public class CustomerController {

    private CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping("/customer")
    public ResponseEntity<Customer> saveUser(@RequestBody Customer customer) throws UserAlreadyExistsException{
        ResponseEntity responseEntity;
            customerService.addRestaurants(customer);
            responseEntity = new ResponseEntity<String>("Sucessfully created",HttpStatus.CREATED);
            return responseEntity;
    }

    @GetMapping("/customers")
    public ResponseEntity<List<Customer>> getAllUsers(@RequestBody Customer user){
        return new ResponseEntity<List<Customer>>(customerService.getAllRestaurants(),HttpStatus.OK);
    }

    @GetMapping("/customer/{id}")
    public ResponseEntity<Optional<Customer>> getUserById(@PathVariable int id) {
        return new ResponseEntity<Optional<Customer>>(customerService.getRestaurantById(id),HttpStatus.OK);
    }

    @GetMapping("/customers/{name}")
    public ResponseEntity<List<Customer>> getUserByName(@PathVariable String name) throws UserNotFoundException{
            ResponseEntity responseEntity;
            responseEntity = new ResponseEntity<List<Customer>>(customerService.getRestaurantByName(name), HttpStatus.CREATED);
            return responseEntity;
       // return new ResponseEntity<List<Customer>>(customerService.getRestaurantByName(name),HttpStatus.OK);
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
